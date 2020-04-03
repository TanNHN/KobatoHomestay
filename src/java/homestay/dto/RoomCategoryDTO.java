/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.dto;

/**
 *
 * @author Tan
 */
public class RoomCategoryDTO {

    private String categoryRoomID;
    private String categoryRoomName;
    private String desciption;

    public RoomCategoryDTO(String categoryRoomID, String categoryRoomName, String desciption) {
        this.categoryRoomID = categoryRoomID;
        this.categoryRoomName = categoryRoomName;
        this.desciption = desciption;
    }

    public RoomCategoryDTO() {
    }

    public String getCategoryRoomID() {
        return categoryRoomID;
    }

    public void setCategoryRoomID(String categoryRoomID) {
        this.categoryRoomID = categoryRoomID;
    }

    public String getCategoryRoomName() {
        return categoryRoomName;
    }

    public void setCategoryRoomName(String categoryRoomName) {
        this.categoryRoomName = categoryRoomName;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }


    

}
