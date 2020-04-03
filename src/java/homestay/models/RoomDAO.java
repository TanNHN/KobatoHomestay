/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import homestay.dto.RoomDTO;

/**
 *
 * @author Tan
 */
public class RoomDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (cnn != null) {
            cnn.close();
        }
    }

    String roomCate = null;
    String roomID = null;
    String roomName = null;
    float price = 0;
    String info = null;
    String photo = null;
    boolean status;

    public List<RoomDTO> getAllRoom() throws Exception {
        List<RoomDTO> list = new ArrayList<>();

        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategory],[RoomID],[RoomName],[Price],[Info],[Photo],[Status] FROM [dbo].[Room]";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    roomCate = rs.getString("RoomCategory");
                    roomID = rs.getString("RoomID");
                    roomName = rs.getString("RoomName");
                    price = rs.getFloat("Price");
                    info = rs.getString("Info");
                    photo = rs.getString("photo");
                    status = rs.getBoolean("Status");
                    list.add(new RoomDTO(roomID, roomCate, roomName, info, price, photo, status));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public RoomDTO getRoomFromID(String id) throws Exception {
        RoomDTO dto = null;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategory],[RoomID],[RoomName],[Price],[Info],[Photo],[Status] FROM [dbo].[Room] WHERE [RoomID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    roomCate = rs.getString("RoomCategory");
                    roomID = rs.getString("RoomID");
                    roomName = rs.getString("RoomName");
                    price = rs.getFloat("Price");
                    info = rs.getString("Info");
                    photo = rs.getString("photo");
                    status = rs.getBoolean("Status");
                    dto = new RoomDTO(roomID, roomCate, roomName, info, price, photo, status);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<RoomDTO> getRoomFromCategory(String cateID) throws Exception {
        List<RoomDTO> list = new ArrayList<>();
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategory],[RoomID],[RoomName],[Price],[Info],[Photo],[Status] FROM [dbo].[Room] WHERE [RoomCategory] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, cateID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    roomCate = rs.getString("RoomCategory");
                    roomID = rs.getString("RoomID");
                    roomName = rs.getString("RoomName");
                    price = rs.getFloat("Price");
                    info = rs.getString("Info");
                    photo = rs.getString("Photo");
                    status = rs.getBoolean("Status");
                    list.add(new RoomDTO(roomID, roomCate, roomName, info, price, photo, status));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<RoomDTO> getRoomFromCategoryWithStatus(boolean status, String cateID) throws Exception {
        List<RoomDTO> list = new ArrayList<>();
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategory],[RoomID],[RoomName],[Price],[Info],[Photo],[Status] FROM [dbo].[Room] WHERE [Status] = ? AND [RoomCategory] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setBoolean(1, status);
                ps.setString(2, cateID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    roomCate = rs.getString("RoomCategory");
                    roomID = rs.getString("RoomID");
                    roomName = rs.getString("RoomName");
                    price = rs.getFloat("Price");
                    info = rs.getString("Info");
                    photo = rs.getString("Photo");
                    status = rs.getBoolean("Status");
                    list.add(new RoomDTO(roomID, roomCate, roomName, info, price, photo, status));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<RoomDTO> getRoomWithStatus(boolean status) throws Exception {
        List<RoomDTO> list = new ArrayList<>();
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategory],[RoomID],[RoomName],[Price],[Info],[Photo],[Status],[RoomCategory] FROM [dbo].[Room] WHERE [Status] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setBoolean(1, status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    roomCate = rs.getString("RoomCategory");
                    roomID = rs.getString("RoomID");
                    roomName = rs.getString("RoomName");
                    price = rs.getFloat("Price");
                    info = rs.getString("Info");
                    photo = rs.getString("Photo");
                    status = rs.getBoolean("Status");
                    list.add(new RoomDTO(roomID, roomCate, roomName, info, price, photo, status));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateRoom(String roomID, String roomName, float Price, String info, String photo, boolean status, String roomCate) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "UPDATE [dbo].[Room] SET [RoomID] = ?,[RoomName] = ?,[Price] = ?,[Info]= ?,[Photo] = ?,[Status]= ?,[RoomCategory]=?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, roomID);
                ps.setString(2, roomName);
                ps.setFloat(3, price);
                ps.setString(4, info);
                ps.setString(5, photo);
                ps.setBoolean(6, status);
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean insertRoom(RoomDTO dto) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "INSERT INTO [dbo].[Room]([RoomID],[RoomName],[Price],[Info],[Photo],[Status],[RoomCategory]) values (?,?,?,?,?,?,?)";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, dto.getRoomID());
                ps.setString(2, dto.getRoomName());
                ps.setFloat(3, dto.getPrice());
                ps.setString(4, dto.getInfo());
                ps.setString(5, dto.getPhoto());
                ps.setString(6, "1");
                ps.setString(7, dto.getRoomCategory());
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteRoom(String roomID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM [dbo].[Booking] WHERE [RoomID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, roomID);
                ps.execute();
                String sql2 = "DELETE FROM [dbo].[Room] WHERE [RoomID] = ?";
                ps = cnn.prepareStatement(sql2);
                ps.setString(1, roomID);
                check = ps.executeUpdate() > 0;

            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean editRoom(String rName, String rInfo, float rPrice, String rCate, String rID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "UPDATE [dbo].[Room] SET [RoomName] = ?, [Price] = ?, [Info] = ?, [RoomCategory] = ? WHERE [RoomID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, rName);
                ps.setFloat(2, rPrice);
                ps.setString(3, rInfo);
                ps.setString(4, rCate);
                ps.setString(5, rID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
