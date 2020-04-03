/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.BookingDTO;
import homestay.models.BookingDAO;
import homestay.models.Cart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tan
 */
public class BookRoomController extends HttpServlet {

    private static final String SUCCESS = "ViewMyBookingController";
    private static final String FAILED = "error.jsp";
    private static final String INVALID = "ShowRoomDetailController";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAILED;
        try {
            boolean chk;
            BookingDAO bookingDAO = new BookingDAO();
            String roomID = request.getParameter("txtRoomID");
            HttpSession session = request.getSession();
            Cart bookingCart = (Cart) session.getAttribute("CART");
            BookingDTO bookingDTO = bookingCart.getCart().get(roomID);
            chk = bookingDAO.createBooking(bookingDTO);
            if (chk) {
                url = SUCCESS;
                bookingCart.delete(roomID);
            } else {
                request.setAttribute("ERROR", "FAILED TO MAKE THIS BOOKING!");
            }
        } catch (Exception e) {
            log("ERROR AT BOOK ROOM CONTROLLER: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("STATUS", "You already made a request for this room, please 'View your booking' for more detail ");
                url = INVALID;
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
