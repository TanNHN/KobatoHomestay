/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.dto;

import java.io.Serializable;

/**
 *
 * @author Tan
 */
public class AccountDTO implements Serializable {

    private int accountID;
    private String accountName;
    private String password;
    private String fullname;
    private int age;
    private String phone;
    private String role;

    public AccountDTO() {
    }

    public AccountDTO(int accountID, String accountName, String fullname, int age, String phone, String role) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
