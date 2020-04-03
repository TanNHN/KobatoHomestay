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
public class RoomDTO {

    private String roomID;
    private String roomCategory;
    private String roomName;
    private String info;
    private float price;
    private String photo;
    private boolean status;

    public RoomDTO(String roomID, String roomCategory, String roomName, String info, float price, String photo, boolean status) {
        this.roomID = roomID;
        this.roomCategory = roomCategory;
        this.roomName = roomName;
        this.info = info;
        this.price = price;
        this.photo = photo;
        this.status = status;
    }

    public String getRoomID() {
        return roomID;
    }

    public RoomDTO() {
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
