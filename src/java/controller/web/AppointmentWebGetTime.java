/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.web;

import dal.AppointmentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Service;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AppointmentWebGetTime", urlPatterns = {"/getAvalTime"})
public class AppointmentWebGetTime extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("avalTime", null);
        response.sendRedirect("appointmentWeb");
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
                Date picked = Date.valueOf(request.getParameter("date"));
        int eid = Integer.parseInt(request.getParameter("employee"));
        HttpSession session = request.getSession();
        HashMap<Integer, Service> bookingMap = (HashMap<Integer, Service>) session.getAttribute("bookingServices");
        double totalTime = 0;
        for(int typeID : bookingMap.keySet()){
            totalTime += bookingMap.get(typeID).getTime();
        }
        AppointmentDBContext aptDBC = new AppointmentDBContext();
        ArrayList<Double> availableTime = aptDBC.getAvailableTime(totalTime/60.0, picked, eid);
        session.setAttribute("picked", picked);
        session.setAttribute("eid", eid);
        session.setAttribute("avalTime", availableTime);
        response.sendRedirect("appointmentWeb");
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
