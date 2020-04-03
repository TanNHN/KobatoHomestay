/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.models;

import homestay.dto.BookingDTO;
import java.util.HashMap;

/**
 *
 * @author Tan
 */
public class Cart {

    private String userName;
    private HashMap<String, BookingDTO> cart;

    public Cart(String userName) {
        this.userName = userName;
        this.cart = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean addToCart(BookingDTO dto) {
        if (this.cart.containsKey(dto.getRoomID())) {
            return false;
        } else {
            cart.put(dto.getRoomID(), dto);
            return true;
        }
    }

    public HashMap<String, BookingDTO> getCart() {
        return cart;
    }

    public void update(BookingDTO booking) {
        if (this.cart.containsKey(booking.getRoomID())) {
            this.cart.get(booking.getRoomID()).setCheckInDate(booking.getCheckInDate());
            this.cart.get(booking.getRoomID()).setCheckOutDate(booking.getCheckOutDate());
            this.cart.get(booking.getRoomID()).setDownPayment(booking.getDownPayment());
            this.cart.get(booking.getRoomID()).setTotal(booking.getTotal());
        }
    }

    public void delete(String id) {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

}
