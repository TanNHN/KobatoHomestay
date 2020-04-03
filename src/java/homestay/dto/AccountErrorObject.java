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
public class AccountErrorObject implements Serializable{
    private String usernameError;
    private String passwordError;
    private String fullNameError;
    private String confirmPasswordError;
    private String newPasswordError;
    private String ageError;
    private String phoneError;

    public String getNewPasswordError() {
        return newPasswordError;
    }

    public void setNewPasswordError(String newPasswordError) {
        this.newPasswordError = newPasswordError;
    }
    
    
    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }
    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getConfirmPassword() {
        return confirmPasswordError;
    }

    public void setConfirmPassword(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    public String getAgeError() {
        return ageError;
    }

    public void setAgeError(String ageError) {
        this.ageError = ageError;
    }    
    
    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
    
    
}
