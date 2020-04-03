/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

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
public class MainController extends HttpServlet {

    private static final String LOGIN = "LoginController";
    private static final String REGISTER = "register.jsp";
    private static final String ERROR = "error.jsp";
    private static final String VIEW_PROFILE = "ViewProfileController";
    private static final String SHOW_ALL_ROOM = "ShowAllRoomController";
    private static final String SHOW_ROOM_FROM_CATEGORY_WITH_STATUS = "GetRoomFromCategoryWithStatusController";
    private static final String SIGN_UP = "RegistController";
    private static final String LOG_OUT = "LogOutController";
    private static final String SHOW_ALL_ROOM_TO_ADMIN = "ShowAllRoomToAdminController";
    private static final String SHOW_ALL_ROOM_WITH_STATUS = "ShowAllRoomWithStatusController";
    private static final String SHOW_ROOM_FROM_CATEGORY = "ShowRoomFromCategoryController";
    private static final String SHOW_ROOM_DETAIL = "ShowRoomDetailController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String SEARCH_USER = "SearchUserCOntroller";
    private static final String UPDATE_USER = "UpdateUserController";
    private static final String DELETE_USER = "DeleteUserController";
    private static final String INSERT_ROOM = "InsertRoomController";
    private static final String DELETE_ROOM = "DeleteRoomController";
    private static final String SHOW_BOOKING_REQUEST = "ShowBookingListController";
    private static final String SHOW_MY_BOOKING = "ViewMyBookingController";
    private static final String DELETE_FROM_CART = "DeleteFromCartController";
    private static final String SHOW_ALL_BOOKING_REQUEST = "ShowAllUserBookingRequestController";
    private static final String CONFIRM_CHANGE = "EditCartController";
    private static final String BOOK_ROOM = "BookRoomController";
    private static final String SHOW_MY_ROOM = "ShowUserRoomController";
    private static final String SHOW_ALL_BOOKED_ROOM = "ShowAllBookedRoomController";
    private static final String DELETE_BOOKING = "DeleteBookingController";
    private static final String CONFIRM_REQUEST = "ConfirmRequestController";
    private static final String CHECK_OUT = "CheckOutController";
    private static final String SHOW_ALL_USER_BOOK = "ShowAllUserBookController";
    private static final String DELETE_BOOKING_REQUEST = "DeleteBookingRequestController";
    private static final String EDIT_ROOM = "edit_room.jsp";
    private static final String EDIT_THIS_ROOM = "EditRoomController";
    private static final String CHANGE_DATE = "edit_cart.jsp";
    private static final String EDIT_PROFILE = "edit_profile.jsp";
    private static final String UPDATE_PROFILE = "UpdateProfileController";
    private static final String CHANGE_PASSWORD = "change_password.jsp";
    private static final String CONFIRM_CHANGE_PASSWORD = "GetUserPasswordController";

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
        String url = ERROR;
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("ROLE");
        if (role == null) {
            role = "";
        }
        try {
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("ViewProfile") && (role.equals("admin") || role.equals("user"))) {
                url = VIEW_PROFILE;
            } else if (action.equals("ShowAllRoom")) {
                url = SHOW_ALL_ROOM;
            } else if (action.equals("GetRoomFromCategoryWithStatus") && role.equals("admin")) {
                url = SHOW_ROOM_FROM_CATEGORY_WITH_STATUS;
            } else if (action.equals("Register")) {
                url = REGISTER;
            } else if (action.equals("SIGNUP")) {
                url = SIGN_UP;
            } else if (action.equals("LogOut")) {
                url = LOG_OUT;
            } else if (action.equals("ShowAllRoomToAdmin") && role.equals("admin")) {
                url = SHOW_ALL_ROOM_TO_ADMIN;
            } else if (action.equals("ShowAllRoomWithStatus") && role.equals("admin")) {
                url = SHOW_ALL_ROOM_WITH_STATUS;
            } else if (action.equals("ShowRoomFromCategory")) {
                url = SHOW_ROOM_FROM_CATEGORY;
            } else if (action.equals("Room Detail")) {
                url = SHOW_ROOM_DETAIL;
            } else if (action.equals("Add to Cart")) {
                url = ADD_TO_CART;
            } else if (action.equals("Search") && role.equals("admin")) {
                url = SEARCH_USER;
            } else if (action.equals("Edit User") && role.equals("admin")) {
                url = UPDATE_USER;
            } else if (action.equals("Delete User") && role.equals("admin")) {
                url = DELETE_USER;
            } else if (action.equals("Create Room") && role.equals("admin")) {
                url = INSERT_ROOM;
            } else if (action.equals("Delete Room") && role.equals("admin")) {
                url = DELETE_ROOM;
            } else if (action.equals("ShowBookingList") && role.equals("admin")) {
                url = SHOW_BOOKING_REQUEST;
            } else if (action.equals("ShowMyBooking") && (role.equals("admin") || role.equals("user"))) {
                url = SHOW_MY_BOOKING;
            } else if (action.equals("Delete") && (role.equals("admin") || role.equals("user"))) {
                url = DELETE_FROM_CART;
            } else if (action.equals("ShowAllBookingRequest") && role.equals("admin")) {
                url = SHOW_ALL_BOOKING_REQUEST;
            } else if (action.equals("Confirm change") && (role.equals("admin") || role.equals("user"))) {
                url = CONFIRM_CHANGE;
            } else if (action.equals("Book Room") && (role.equals("admin") || role.equals("user"))) {
                url = BOOK_ROOM;
            } else if (action.equals("ShowMyRoom") && (role.equals("admin") || role.equals("user"))) {
                url = SHOW_MY_ROOM;
            } else if (action.equals("ShowAllBookedRoom") && role.equals("admin")) {
                url = SHOW_ALL_BOOKED_ROOM;
            } else if (action.equals("Cancel") && (role.equals("admin") || role.equals("user"))) {
                url = DELETE_BOOKING;
            } else if (action.equals("Confirm") && role.equals("admin")) {
                url = CONFIRM_REQUEST;
            } else if (action.equals("Check Out") && role.equals("admin")) {
                url = CHECK_OUT;
            } else if (action.equals("ShowAllBook") && role.equals("admin")) {
                url = SHOW_ALL_USER_BOOK;
            } else if (action.equals("Delete this booking") && role.equals("admin")) {
                url = DELETE_BOOKING_REQUEST;
            } else if (action.equals("Edit Room") && role.equals("admin")) {
                url = EDIT_ROOM;
            } else if (action.equals("Change Date") && (role.equals("admin") || role.equals("user"))) {
                url = CHANGE_DATE;
            } else if (action.equals("Edit This Room") && role.equals("admin")) {
                url = EDIT_THIS_ROOM;
            } else if (action.equals("Edit Profile") && (role.equals("admin") || role.equals("user"))) {
                url = EDIT_PROFILE;
            } else if (action.equals("Update Profile") && (role.equals("admin") || role.equals("user"))) {
                url = UPDATE_PROFILE;
            } else if (action.equals("Change Password") && (role.equals("admin") || role.equals("user"))) {
                url = CHANGE_PASSWORD;
            } else if (action.equals("Confirm Change Password") && (role.equals("admin") || role.equals("user"))) {
                url = CONFIRM_CHANGE_PASSWORD;
            }else {
                request.setAttribute("ERROR", "INVALID ACTION");
            }
        } catch (Exception e) {
            log("ERROR AT MAINCONTROLLER " + e.getMessage());
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
