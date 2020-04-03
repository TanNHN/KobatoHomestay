/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import homestay.models.AccountDAO;
import homestay.dto.AccountDTO;
import homestay.dto.AccountErrorObject;

/**
 *
 * @author Tan
 */
public class LoginController extends HttpServlet {

    private static final String FAIL = "error.jsp";
    private static final String INVALID = "login.jsp";
    private static final String SUCCESS = "index.jsp";

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
            HttpSession session = request.getSession();
            String chkRole = (String) session.getAttribute("ROLE");
            if (chkRole == null) {
                session.setAttribute("ROLE", "");
            }
            boolean valid = true;
            AccountErrorObject accountErrorObj = new AccountErrorObject();
            String uname = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            if (uname.length() < 6) {
                valid = false;
                url = INVALID;
                accountErrorObj.setUsernameError("Username have more than 6 characters");
            }
            if (password.length() < 6) {
                valid = false;
                url = INVALID;
                accountErrorObj.setPasswordError("Password have more then 6 characters");
            }
            if (valid) {
                AccountDTO dto;
                AccountDAO dao = new AccountDAO();
                dto = dao.checkLogin(uname, password);
                if (dto != null) {
                    session.setAttribute("ID", dto.getAccountID());
                    session.setAttribute("USERNAME", dto.getFullname());
                    session.setAttribute("ROLE", dto.getRole());
                    if (dto.getRole().equals("admin")) {
                        url = SUCCESS;
                    } else if (dto.getRole().equals("user")) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "INVALID ROLE");
                    }
                }else{
                    url = FAIL;
                    request.setAttribute("ERROR", "Wrong username or password");
                }

            } else {
                url = INVALID;
                request.setAttribute("INVALID", accountErrorObj);
            }
        } catch (Exception e) {
            log("ERROR AT LOGIN CONTROLLER: " + e.getMessage());
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
