/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.models;

import homestay.dto.BookingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import homestay.dto.RoomDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tan
 */
public class BookingDAO {

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

    public boolean createBooking(int accountID, String roomID, String chkIn, String chkOut) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "INSERT INTO [dbo].[Booking]([AccountID],[RoomID],[CheckIn],[CheckOut]) values (?, ?, ?, ?)";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, accountID);
                ps.setString(2, roomID);
                ps.setString(3, chkIn);
                ps.setString(4, chkOut);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public RoomDTO getBookingRoom(String id) {
        RoomDTO dto = null;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [BookingID],[AccountID],[RoomID],[CheckIn],[CheckOut] FROM [dbo].[Booking] WHERE [RoomID] = ?";
            }
        } catch (Exception e) {
        }
        return dto;
    }

    public List<BookingDTO> getBookingBasedOnStatus(int id, boolean status) throws Exception {
        List<BookingDTO> list = new ArrayList<>();
        AccountDAO accountDAO = new AccountDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            int aID = 0;
            String rID;
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [BookingID],[AccountID],[RoomID],[BookDate],[CheckIn],[CheckOut],[Total],[Downpayment],[Status] FROM [dbo].[Booking] WHERE [AccountID] = ? AND [Status] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setBoolean(2, status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookingID = rs.getInt("BookingID");
                    aID = rs.getInt("AccountID");
                    rID = rs.getString("RoomID");
                    Date bookDate = rs.getTimestamp("BookDate");
                    String chkIn = rs.getString("CheckIn");
                    String chkOut = rs.getString("CheckOut");
                    float downPayment = rs.getFloat("Downpayment");
                    float total = rs.getFloat("Total");
                    boolean stt = rs.getBoolean("Status");

                    list.add(new BookingDTO(bookingID, aID, rID, bookDate, chkIn, chkOut, total, roomDAO.getRoomFromID(rID), accountDAO.getAccountDetailFromID(aID), downPayment, stt));
                }

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookingDTO> getBookingListFromUser(int id) throws Exception {
        List<BookingDTO> list = new ArrayList<>();
        AccountDAO accountDAO = new AccountDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            int aID = 0;
            String rID;
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [BookingID],[AccountID],[RoomID],[BookDate],[CheckIn],[CheckOut],[Total],[Downpayment],[Status] FROM [dbo].[Booking] WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookingID = rs.getInt("BookingID");
                    aID = rs.getInt("AccountID");
                    rID = rs.getString("RoomID");
                    Date bookDate = rs.getTimestamp("BookDate");
                    String chkIn = rs.getString("CheckIn");
                    String chkOut = rs.getString("CheckOut");
                    float downPayment = rs.getFloat("Downpayment");
                    float total = rs.getFloat("Total");
                    boolean stt = rs.getBoolean("Status");

                    list.add(new BookingDTO(bookingID, aID, rID, bookDate, chkIn, chkOut, total, roomDAO.getRoomFromID(rID), accountDAO.getAccountDetailFromID(aID), downPayment, stt));
                }

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookingDTO> getAllBookingRoom() throws Exception {
        List<BookingDTO> list = new ArrayList<>();
        AccountDAO accountDAO = new AccountDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            int aID = 0;
            String rID;
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [BookingID],[AccountID],[RoomID],[BookDate],[CheckIn],[CheckOut],[Total],[Downpayment],[Status] FROM [dbo].[Booking]";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookingID = rs.getInt("BookingID");
                    aID = rs.getInt("AccountID");
                    rID = rs.getString("RoomID");
                    Date bookDate = rs.getTimestamp("BookDate");
                    String chkIn = rs.getString("CheckIn");
                    String chkOut = rs.getString("CheckOut");
                    float downPayment = rs.getFloat("Downpayment");
                    float total = rs.getFloat("Total");
                    boolean status = rs.getBoolean("Status");
                    list.add(new BookingDTO(bookingID, aID, rID, bookDate, chkIn, chkOut, total, roomDAO.getRoomFromID(rID), accountDAO.getAccountDetailFromID(aID), downPayment, status));
                }

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<BookingDTO> getAllBookingRequest(boolean status) throws Exception {
        List<BookingDTO> list = new ArrayList<>();
        AccountDAO accountDAO = new AccountDAO();
        RoomDAO roomDAO = new RoomDAO();
        try {
            int aID = 0;
            String rID;
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [BookingID],[AccountID],[RoomID],[BookDate],[CheckIn],[CheckOut],[Total],[Downpayment],[Status] FROM [dbo].[Booking] WHERE [Status] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setBoolean(1, status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookingID = rs.getInt("BookingID");
                    aID = rs.getInt("AccountID");
                    rID = rs.getString("RoomID");
                    Date bookDate = rs.getTimestamp("BookDate");
                    String chkIn = rs.getString("CheckIn");
                    String chkOut = rs.getString("CheckOut");
                    float downPayment = rs.getFloat("Downpayment");
                    float total = rs.getFloat("Total");
                    boolean stt = rs.getBoolean("Status");
                    list.add(new BookingDTO(bookingID, aID, rID, bookDate, chkIn, chkOut, total, roomDAO.getRoomFromID(rID), accountDAO.getAccountDetailFromID(aID), downPayment, stt));
                }

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean createBooking(BookingDTO book) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                Timestamp ts = new Timestamp(book.getBookDate().getTime());
                String sql = "INSERT INTO [dbo].[Booking]([AccountID],[RoomID],[BookDate],[CheckIn],[CheckOut],[Downpayment],[Total],[Status]) values (?,?,?,?,?,?,?,?)";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, book.getAccountID());
                ps.setString(2, book.getRoomID());
                ps.setTimestamp(3, ts);
                ps.setString(4, book.getCheckInDate());
                ps.setString(5, book.getCheckOutDate());
                ps.setFloat(6, book.getDownPayment());
                ps.setFloat(7, book.getTotal());
                ps.setBoolean(8, book.isStatus());
                check = ps.executeUpdate() > 0;
            }
            if (check) {
                String sql2 = "UPDATE [dbo].[Room] SET [Status] = 0 WHERE [RoomID] = ?";
                ps = cnn.prepareStatement(sql2);
                ps.setString(1, book.getRoomID());
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteBooking(int bookingID, String roomID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM [dbo].[Booking] WHERE [BookingID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, bookingID);
                check = ps.executeUpdate() > 0;
                if (check) {
                    String sql2 = "UPDATE [dbo].[Room] SET [Status] = 1 WHERE [RoomID] = ?";
                    ps = cnn.prepareStatement(sql2);
                    ps.setString(1, roomID);
                    check = ps.executeUpdate() > 0;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean confirmBookingRequest(int bookingID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "	UPDATE [dbo].[Booking] SET [Status] = 1 WHERE [BookingID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, bookingID);
                check = ps.executeUpdate() > 0;
            }

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkOutRoom(int bookingID, String roomID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM [dbo].[Booking] WHERE [BookingID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, bookingID);
                check = ps.executeUpdate() > 0;
                if (check) {
                    String sql2 = "UPDATE [dbo].[Room] SET [Status] = 1 WHERE [RoomID] = ?";
                    ps = cnn.prepareStatement(sql2);
                    ps.setString(1, roomID);
                    check = ps.executeUpdate() > 0;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }

}
