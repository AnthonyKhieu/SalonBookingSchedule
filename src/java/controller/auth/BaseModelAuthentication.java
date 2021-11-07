/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.auth;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Feature;

/**
 *
 * @author Admin
 */
public abstract class BaseModelAuthentication extends HttpServlet {

    protected boolean isAuthenticated(HttpServletRequest request){
        Account a = (Account) request.getSession().getAttribute("account");
        if(a != null){
            String url = request.getServletPath();
            for(Feature f : a.getFeatures()){
                if(f.getUrl().equals(url)){
                    return true;
                }
            }
        }
        return false;
    }
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
        if(isAuthenticated(request)){
            processGet(request, response);
        }
        else{
            response.getWriter().println("Access Denied!");
        }
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
        if(isAuthenticated(request)){
            processPost(request, response);
        }
        else{
            response.getWriter().println("Access Denied!");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
