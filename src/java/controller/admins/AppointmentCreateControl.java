/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import controller.auth.BaseModelAuthentication;
import dal.AppointmentDBContext;
import dal.CustomerDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;
import model.Customer;
import model.Employee;
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AppointmentCreateControl", urlPatterns = {"/admin/createAppointment"})
public class AppointmentCreateControl extends BaseModelAuthentication {

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
        HttpSession session = request.getSession();
        HashMap<Integer, Service> bookingMap = (HashMap<Integer, Service>) session.getAttribute("bookingServices");
        CustomerDBContext cusDBC = new CustomerDBContext();
        EmployeeDBContext empDBC = new EmployeeDBContext();
        AppointmentDBContext aptDBC = new AppointmentDBContext();

        String clientPhone = (String) session.getAttribute("clientPhone");
        Customer c = cusDBC.getByPhoneNumber(clientPhone);
        if (c == null) {
            c = new Customer();
            c.setName(request.getParameter("clientName"));
            c.setPhone(clientPhone);
            cusDBC.insert(c);
        }
        int eid = (int) session.getAttribute("eid");
        Employee e = empDBC.getByID(eid);
        
        Date date = (Date) session.getAttribute("date");
        
        double totalTime = 0;
        double fromHour = Double.parseDouble(request.getParameter("fromHour"));
        String description = request.getParameter("description");
        
        Appointment a = new Appointment();
        a.setCustomer(c);
        a.setEmployee(e);
        a.setFromHour(fromHour);
        a.setDate(date);
        a.setDescription(description);
        for(int typeID : bookingMap.keySet()){
            a.getServices().add(bookingMap.get(typeID));
        }
        double toHour = fromHour + totalTime;
        a.setToHour(toHour);
        
        aptDBC.insert(a);
        String url = request.getHeader("Referer");
        response.sendRedirect(url);
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
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
