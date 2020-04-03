/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.AccountDTO;
import homestay.dto.BookingDTO;
import homestay.dto.BookingErrorObject;
import homestay.models.AccountDAO;
import homestay.models.Cart;
import homestay.models.RoomDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tan
 */
public class AddToCartController extends HttpServlet {

    private static final String SUCCESS = "view_cart.jsp";
    private static final String FAIL = "ShowRoomDetailController";

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
        BookingErrorObject beo = new BookingErrorObject();

        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("ID") == null) {
                request.setAttribute("STATUS", "Please login to make reservation");
            } else {
                boolean valid = true;
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                int id = Integer.parseInt(session.getAttribute("ID").toString());
                String accountName = session.getAttribute("USERNAME").toString();
                Cart bookingCart = (Cart)session.getAttribute("CART");
                if (bookingCart == null) {
                    bookingCart = new Cart(accountName);
                }
                RoomDAO roomDAO = new RoomDAO();
                AccountDAO accountDAO = new AccountDAO();
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
                    Timestamp ts = new Timestamp(curDate.getTime());
                    long timeStay = date2.getTime() - date1.getTime();
                    float stay = TimeUnit.DAYS.convert(timeStay, TimeUnit.MILLISECONDS) + 1;
                    long chkCheckIn = date1.getTime() - ts.getTime();
                    float checkCheckIn = TimeUnit.DAYS.convert(chkCheckIn, TimeUnit.MILLISECONDS);
                    if (checkCheckIn < 0) {
                        validDate = false;
                        beo.setCheckInError("You can't set check in as the day in the past ");
                    }
                    if (stay <= 0) {
                        validDate = false;
                        beo.setDateDistanceError("Check in date must be smaller than Check out date");
                    }
                    if (checkCheckIn > 7) {
                        validDate = false;
                        beo.setCheckInError("Your check in day is too far. Maximum is 7 day");
                    }
                    if (validDate) {
                        float total = price * stay;
                        float downPayment = total / 10;
                        boolean status = false;
                        BookingDTO dto = new BookingDTO(id, roomID, ts, chkIn, chkOut, total, roomDAO.getRoomFromID(roomID), accountDAO.getAccountDetailFromID(id), downPayment, status);
                        boolean check = bookingCart.addToCart(dto);
                        if (check) {
                            url = SUCCESS;
                            session.setAttribute("CART", bookingCart);
                        } else {
                            url = FAIL;
                            request.setAttribute("STATUS", "THIS ROOM IS ALREADY IN YOUR CART");
                        }
                    } else {
                        request.setAttribute("INVALID", beo);
                        url = FAIL;
                    }

                } else {
                    request.setAttribute("INVALID", beo);
                    url = FAIL;
                }
            }
        } catch (Exception e) {
            log("ERROR AT ADD TO CART CONTROLLER: " + e.getMessage());
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
