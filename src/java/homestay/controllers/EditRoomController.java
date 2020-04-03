/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.RoomErrorObject;
import homestay.models.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tan
 */
public class EditRoomController extends HttpServlet {

    private static final String SUCCESS = "ShowAllRoomToAdminController";
    private static final String FAIL = "error.jsp";
    private static final String INVALID = "edit_room.jsp";

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
        boolean valid = true;
        try {
            String rID = request.getParameter("txtRoomID");
            
            RoomErrorObject reo = new RoomErrorObject();
            String rName = request.getParameter("txtRoomName");
            String rInfo = request.getParameter("txtInfo");
            float price = 0;
            String rCate = request.getParameter("slCate");
            if (rName.length() == 0) {
                reo.setRoomNameERROR("Room Name can't be empty");
                valid = false;
            }
            if (rInfo.length() == 0) {
                reo.setRoomInfoError("Please input some Info");
                valid = false;
            }
            if (request.getParameter("txtPrice").length() == 0) {
                reo.setRoomPriceError("Price can't be empty");
                valid = false;
            } else {
                if (request.getParameter("txtPrice").matches("[+]?[0-9]*\\.?[0-9]+")) {
                    if (Float.parseFloat(request.getParameter("txtPrice")) < 0) {
                        reo.setRoomPriceError("Price must be positive");
                        valid = false;
                    } else {
                        price = Float.parseFloat(request.getParameter("txtPrice"));
                    }
                }else{
                    reo.setRoomPriceError("Price must be numer");
                    valid = false;
                }

            }
            if (rCate.equals("")) {
                reo.setRoomCateError("Please select room's category");
                valid = false;
            }
            if (valid) {
                RoomDAO roomDAO = new RoomDAO();
                boolean check = roomDAO.editRoom(rName, rInfo, price, rCate, rID);
                if (check) {
                    url = SUCCESS;
                    
                } else {
                    request.setAttribute("ERROR", "Edit Room FAILED");
                }
            } else {
                request.setAttribute("INVALID", reo);
                url = INVALID;
            }
        } catch (Exception e) {
            log("ERROR AT EDIT CONTROLLER: " + e.getMessage());
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
