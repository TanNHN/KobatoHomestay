/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.dto;

import java.util.Date;

/**
 *
 * @author Tan
 */
public class BookingDTO {

    private int bookingID;
    private int accountID;
    private String roomID;
    private Date bookDate;
    private String checkInDate;
    private String checkOutDate;
    private float Total;
    private RoomDTO room;
    private AccountDTO account;
    private float downPayment;
    private boolean status;

    public BookingDTO(String roomID, String checkInDate, String checkOutDate, float Total, float downPayment) {
        this.roomID = roomID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.Total = Total;
        this.downPayment = downPayment;
    }
    
    public BookingDTO(int bookingID, int accountID, String roomID, Date bookDate, String checkInDate, String checkOutDate, float Total, RoomDTO room, AccountDTO account, float downPayment, boolean status) {
        this.bookingID = bookingID;
        this.accountID = accountID;
        this.roomID = roomID;
        this.bookDate = bookDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.Total = Total;
        this.room = room;
        this.account = account;
        this.downPayment = downPayment;
        this.status = status;
    }

    

    public BookingDTO(int accountID, String roomID, Date bookDate, String checkInDate, String checkOutDate, float Total, RoomDTO room, AccountDTO account, float downPayment, boolean status) {
        this.accountID = accountID;
        this.roomID = roomID;
        this.bookDate = bookDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.Total = Total;
        this.room = room;
        this.account = account;
        this.downPayment = downPayment;
        this.status = status;
    }

    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
    public float getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(float downPayment) {
        this.downPayment = downPayment;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public BookingDTO() {
    }
    
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

}
