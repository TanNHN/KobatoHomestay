/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import homestay.dto.RoomCategoryDTO;

/**
 *
 * @author Tan
 */
public class RoomCategoryDAO implements Serializable{
    
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
    
    public List<RoomCategoryDTO> getAllRoomCategory() throws Exception {
        List<RoomCategoryDTO> list = new ArrayList<>();
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [RoomCategoryID],[RoomCategoryName],[Description] FROM [dbo].[CategoryRoom]";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String roomCateID = rs.getString("RoomCategoryID");
                    String roomCateName = rs.getString("RoomCategoryName");
                    String descrip = rs.getString("Description");
                   list.add(new RoomCategoryDTO(roomCateID, roomCateName, descrip));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
}
