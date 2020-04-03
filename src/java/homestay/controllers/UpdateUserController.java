/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.controllers;

import homestay.dto.AccountErrorObject;
import homestay.models.AccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tan
 */
public class UpdateUserController extends HttpServlet {

    private static final String SEARCH = "SearchUserCOntroller";
    private static final String FAILED = "error.jsp";

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
            int age = 0;
            boolean valid = true;
            AccountErrorObject aeo = new AccountErrorObject();
            int id = Integer.parseInt(request.getParameter("txtID"));
            String aName = request.getParameter("txtName");
            String strAge = request.getParameter("txtAge");
            String fName = request.getParameter("txtFullname");
            String phone = request.getParameter("txtPhone");
            String role = request.getParameter("txtRole");
            boolean chkAge = true;
            if (fName.length() == 0) {
                aeo.setFullNameError("Fullname can't be blank");
                valid = false;
                chkAge = false;
            }

            if (strAge.length() == 0) {
                aeo.setAgeError("Age can't be blank");
                valid = false;
            } else {
                for (int i = 0; i < strAge.length(); i++) {
                    if (!Character.isDigit(strAge.charAt(i))) {
                        aeo.setAgeError("Age must be number");
                        valid = false;
                        chkAge = false;
                    }
                }

            }
            boolean chkPhone = true;
            if (chkAge) {
                age = Integer.parseInt(request.getParameter("txtAge"));
                if (age < 18 || age > 80) {
                    aeo.setAgeError("Age must in range 18 - 80");
                    valid = false;
                }
            }
            if (phone.length() == 0) {
                aeo.setPhoneError("Phone can't be blank");
                valid = false;
                chkPhone = false;
            } else {
                for (int i = 0; i < phone.length(); i++) {
                    if (!Character.isDigit(phone.charAt(i))) {
                        aeo.setPhoneError("Phone number must be number");
                        valid = false;
                        chkPhone = false;
                    }
                }
            }
            if (chkPhone) {
                if (phone.length() < 9 || phone.length() > 10) {
                    aeo.setPhoneError("Phone length must in range 9-10 number");
                    valid = false;
                }

            }

            if (valid) {
                AccountDAO accountDAO = new AccountDAO();
                boolean check = accountDAO.updateAccount(id, aName, fName, age, phone, role);
                if (check) {
                    url = SEARCH;
                    request.setAttribute("STATUS", "UserID: " + id + " is updated");
                } else {
                    request.setAttribute("ERROR", "UPDATE ERROR");
                }
            } else {
                request.setAttribute("INVALID", aeo);
                url = SEARCH;
            }
        } catch (Exception e) {
            log("ERROR AT UPDATE USER CONTROLLER: " + e.getMessage());
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
