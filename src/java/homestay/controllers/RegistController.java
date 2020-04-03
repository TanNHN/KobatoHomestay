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
import homestay.models.AccountDAO;
import homestay.dto.AccountErrorObject;

/**
 *
 * @author Tan
 */
public class RegistController extends HttpServlet {

    private static final String SUCCESS = "login.jsp";
    private static final String FAIL = "register.jsp";

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
            int age = 0;
            AccountErrorObject aeo = new AccountErrorObject();
            AccountDAO dao = new AccountDAO();
            boolean valid = true;
            boolean check;
            String aName = request.getParameter("txtAccountname");
            if (aName.length() < 6) {
                valid = false;
                aeo.setUsernameError("Account name length must be more than 6 characters");
            }
            String password = request.getParameter("txtPassword");
            if (password.length() == 0) {
                valid = false;
                aeo.setPasswordError("Password length must be more than 6 character");
            }
            String confirmPassword = request.getParameter("txtConfirmPassword");
            if (!confirmPassword.equals(password)) {
                valid = false;
                aeo.setConfirmPassword("Confirm password doesn't match your password");
            }
            String fullName = request.getParameter("txtFullName");
            if (fullName.length() == 0) {
                valid = false;
                aeo.setFullNameError("Please input your name");
            }
            String strAge = request.getParameter("txtAge");
            String phone = request.getParameter("txtPhone");
            boolean chkAge = true;
            if (strAge.length() == 0) {
                aeo.setAgeError("Age can't be blank");
                valid = false;
                chkAge =false;
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
                    chkPhone = false;
                }
            }
            if (phone.length() == 0) {
                aeo.setPhoneError("Phone can't be blank");
                valid = false;
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
//            String ageStr = request.getParameter("txtAge");

            String role = "user";
            if (valid) {

                check = dao.createAccount(aName, password, fullName, age, phone, role);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("REGIST_STATUS", "REGIST SUCCEDDED");

                }
            } else {
                request.setAttribute("INVALID", aeo);
            }

        } catch (Exception e) {
            log("ERROR AT REGIST CONTROLLER: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                AccountErrorObject aeo = new AccountErrorObject();
                aeo.setUsernameError("This user name is already existed");
                url = FAIL;
                request.setAttribute("INVALID", aeo);
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
