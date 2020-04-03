/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.BookingDTO;
import homestay.dto.BookingErrorObject;
import homestay.models.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;

/**
 *
 * @author Tan
 */
public class EditCartController extends HttpServlet {

    private static final String SUCCESS = "view_cart.jsp";
    private static final String FAIL = "error.jsp";
    private static final String INVALID = "edit_cart.jsp";

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
        String url = FAIL;
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            BookingErrorObject beo = new BookingErrorObject();
            HttpSession session = request.getSession();
            Cart bookingCart = (Cart) session.getAttribute("CART");
            if (session.getAttribute("ROLE") == null) {
                request.setAttribute("STATUS", "Please login to make reservation");
            } else {
                boolean valid = true;
                String chkIn = request.getParameter("txtCheckIn");
                if (chkIn.length() == 0) {
                    beo.setCheckInError("Check in date can't be empty");
                    valid = false;
                }
                String chkOut = request.getParameter("txtCheckOut");
                if (chkOut.length() == 0) {
                    beo.setCheckOutError("Check out date can't be empty");
                    valid = false;
                }

                if (valid) {
                    boolean validDate = true;
                    Date date1 = format.parse(chkIn);

                    float price = Float.parseFloat(request.getParameter("txtPrice"));
                    String roomID = request.getParameter("txtRoomID");

                    Date date2 = format.parse(chkOut);
                    Date curDate = new Date();
                    String today = format.format(curDate);
                    Date tooday = format.parse(today);
                    long timeStay = date2.getTime() - date1.getTime();
                    float stay = TimeUnit.DAYS.convert(timeStay, TimeUnit.MILLISECONDS) + 1;
                    long chkCheckIn = date1.getTime() - tooday.getTime();
                    float checkCheckIn = TimeUnit.DAYS.convert(chkCheckIn, TimeUnit.MILLISECONDS);
                    if (checkCheckIn < 0) {
                        validDate = false;
                        beo.setCheckInError("You can't set check in as the day in the past ");
                    }
                    if (checkCheckIn > 7) {
                        validDate = false;
                        beo.setCheckInError("Your check in day is too far. Maximum is 7 days");
                    }
                    if (stay <= 0) {
                        validDate = false;
                        beo.setDateDistanceError("Check in date must be smaller than Check out date");
                    }
                    if (validDate) {
                        float total = price * stay;
                        float downPayment = total / 10;
                        BookingDTO dto = new BookingDTO(roomID, chkIn, chkOut, total, downPayment);
                        bookingCart.update(dto);
                        session.setAttribute("CART", bookingCart);
                        url = SUCCESS;
                    } else {
                        url = INVALID;
                        request.setAttribute("INVALID", beo);
                    }
                } else {
                    url = INVALID;
                    request.setAttribute("INVALID", beo);
                }
            }
        } catch (Exception e) {
            log("ERROR AT EDIT CART CONTROLLER: " + e.getMessage());
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
