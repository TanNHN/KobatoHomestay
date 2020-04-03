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
import homestay.dto.AccountDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tan
 */
public class AccountDAO {

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

    public AccountDTO checkLogin(String uname, String password) throws Exception {
        AccountDTO dto = null;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM [dbo].[Account] WHERE [AccountName] = ? AND [Password] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int aID = rs.getInt("AccountID");
                    String aName = rs.getString("AccountName");
                    String fName = rs.getString("Fullname");
                    int age = rs.getInt("Age");
                    String phone = rs.getString("Phone");
                    String role = rs.getString("Role");
                    dto = new AccountDTO(aID, aName, fName, age, phone, role);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean createAccount(String aName, String passwrord, String fullname, int age, String phone, String role) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "INSERT INTO [dbo].[Account]([AccountName],[Password],[Fullname],[Age],[Phone],[Role]) values (?, ?, ?, ?, ?, ?)";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, aName);
                ps.setString(2, passwrord);
                ps.setString(3, fullname);
                ps.setInt(4, age);
                ps.setString(5, phone);
                ps.setString(6, role);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<AccountDTO> searchUser(String search) throws Exception {
        List<AccountDTO> list = new ArrayList<>();
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [AccountID],[AccountName],[Fullname],[Age],[Phone],[Role] FROM [dbo].[Account] WHERE [AccountName] LIKE ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int aID = rs.getInt("AccountID");
                    String aName = rs.getString("AccountName");
                    String fullName = rs.getString("Fullname");
                    int age = rs.getInt("Age");
                    String phone = rs.getString("Phone");
                    String role = rs.getString("Role");
                    list.add(new AccountDTO(aID, aName, fullName, age, phone, role));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateAccount(int accountID, String aName, String fullname, int age, String phone, String role) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "UPDATE [dbo].[Account] SET [Fullname] = ?, [Age] = ?, [Phone] = ?, [Role] = ? WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, fullname);
                ps.setInt(2, age);
                ps.setString(3, phone);
                ps.setString(4, role);
                ps.setInt(5, accountID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateProfile(int accountID, String fullname, int age, String phone) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "UPDATE [dbo].[Account] SET [Fullname] = ?, [Age] = ?, [Phone] = ? WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, fullname);
                ps.setInt(2, age);
                ps.setString(3, phone);
                ps.setInt(4, accountID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteAccount(int accountID) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "DELETE FROM [dbo].[Account] WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, accountID);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public AccountDTO getAccountDetailFromID(int id) throws Exception {
        AccountDTO dto = null;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT * FROM [dbo].[Account] WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String aName = rs.getString("AccountName");
                    String fName = rs.getString("Fullname");
                    String role = rs.getString("Role");
                    String phone = rs.getString("Phone");
                    int age = rs.getInt("Age");
                    dto = new AccountDTO(id, aName, fName, age, phone, role);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public String getUserPassword(int id) throws Exception {
        String password = "";
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "SELECT [Password] FROM [dbo].[Account] WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    password = rs.getString("Password");
                }
            }
        } finally {
            closeConnection();
        }
        return password;
    }

    public boolean changePassword(int id, String password) throws Exception {
        boolean check = false;
        try {
            cnn = homestay.db.MyConnection.getConnection();
            if (cnn != null) {
                String sql = "UPDATE [dbo].[Account] SET [Password] = ? WHERE [AccountID] = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, password);
                ps.setInt(2, id);
                check = ps.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
