/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.RoomDTO;
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
public class InsertRoomController extends HttpServlet {

    private static final String SUCCESS = "rooms.jsp";
    private static final String INVALID = "create_room.jsp";
    private static final String FAIL = "error.jsp";

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
        RoomErrorObject reo = new RoomErrorObject();
        try {
            float price = 0;
            boolean valid = true;
            String id = request.getParameter("txtID");
            if (id.length() == 0) {
                valid = false;
                reo.setRoomIdERROR("id can't be empty");
            }
            String name = request.getParameter("txtName");
            if (name.length() == 0) {
                valid = false;
                reo.setRoomNameERROR("name can't be empty");
            }
            if (request.getParameter("txtPrice").length() == 0) {
                reo.setRoomPriceError("Price can't be empty");
            } else {
                if (request.getParameter("txtPrice").matches("[+]?[0-9]*\\.?[0-9]+")) {
                    if (Float.parseFloat(request.getParameter("txtPrice")) < 0) {
                        reo.setRoomPriceError("Price must be positive");
                        valid = false;
                    } else {
                        price = Float.parseFloat(request.getParameter("txtPrice"));
                    }
                } else {
                    reo.setRoomPriceError("Price must be numer");
                    valid = false;
                }

            }
            String info = request.getParameter("txtInfo");
            if (info.length() == 0) {
                valid = false;
                reo.setRoomInfoError("You should give some info about this room");
            }
            String photo = request.getParameter("txtPhoto");
            if (photo.length() == 0) {
                valid = false;
                reo.setRoomPhotoError("please input a photo");
            } else {
                if (photo.length() == 7) {
                    valid = false;
                    reo.setRoomPhotoError("images/*YourPictureNameHere*");
                }
                if (!photo.startsWith("images/")) {
                    valid = false;
                    reo.setRoomPhotoError("images/*YourPictureNameHere*");
                }
            }
            String category = request.getParameter("slCate");
            if (valid) {
                RoomDTO room = new RoomDTO(id, category, name, info, price, photo, true);
                RoomDAO dao = new RoomDAO();
                boolean check = dao.insertRoom(room);
                if (check) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "INSERT ROOM ERROR");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", reo);
            }
        } catch (Exception e) {
            log("ERROR AT INSERT ROOM: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                reo.setRoomIdERROR("This room ID is existed");
                request.setAttribute("INVALID", reo);
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
