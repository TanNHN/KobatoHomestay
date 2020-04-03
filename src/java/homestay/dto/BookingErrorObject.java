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
public class BookingErrorObject {
    private String bookingDateError;
    private String checkInError;
    private String checkOutError;
    private String dateDistanceError;

    public String getDateDistanceError() {
        return dateDistanceError;
    }

    public void setDateDistanceError(String dateDistanceError) {
        this.dateDistanceError = dateDistanceError;
    }
    
    
    
    public String getBookingDateError() {
        return bookingDateError;
    }

    public void setBookingDateError(String bookingDateError) {
        this.bookingDateError = bookingDateError;
    }

    public String getCheckInError() {
        return checkInError;
    }

    public void setCheckInError(String checkInError) {
        this.checkInError = checkInError;
    }

    public String getCheckOutError() {
        return checkOutError;
    }

    public void setCheckOutError(String checkOutError) {
        this.checkOutError = checkOutError;
    }
    
    
    
}
