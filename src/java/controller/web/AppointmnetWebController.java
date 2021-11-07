/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.web;

import dal.AppointmentDBContext;
import dal.CustomerDBContext;
import dal.EmployeeDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Employee;
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AppointmnetWebController", urlPatterns = {"/appointmentWeb"})
public class AppointmnetWebController extends HttpServlet {

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
        String clientPhone = (String) session.getAttribute("clientPhone");
        if (clientPhone == null) {
            response.sendRedirect("home");
        } else {
            HashMap<Integer, Service> bookingMap = (HashMap<Integer, Service>) session.getAttribute("bookingServices");
            if (bookingMap == null) {
                bookingMap = new HashMap<>();
            }
            CustomerDBContext cusDBC = new CustomerDBContext();
            EmployeeDBContext empDBC = new EmployeeDBContext();
            AppointmentDBContext aptDBC = new AppointmentDBContext();
            ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
            
            LocalDate currentDate = LocalDate.now();
            Customer c = cusDBC.getByPhoneNumber(clientPhone);

            ServiceType st_standard = new ServiceType();
            ArrayList<ServiceType> allType = servTypeDBC.getAll(servTypeDBC.getSize(st_standard));
            request.setAttribute("serviceType", allType);
            Employee e = new Employee();
            session.setAttribute("currentDate", currentDate);
            session.setAttribute("clientName", c == null ? null : c.getName());
            session.setAttribute("employeeList", empDBC.getAll(empDBC.getSize(e)));
            session.setAttribute("bookingServices", bookingMap);
            request.getRequestDispatcher("view/web/appointment.jsp").forward(request, response);
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
        int sid = Integer.parseInt(request.getParameter("picked"));
        ServiceDBContext servDBC = new ServiceDBContext();
        Service s = servDBC.getByID(sid);
        HttpSession session = request.getSession();
        HashMap<Integer, Service> bookingMap = (HashMap<Integer, Service>) session.getAttribute("bookingServices");
        if (bookingMap == null) {
            bookingMap = new HashMap<>();
            bookingMap.put(s.getType().getTypeID(), s);
        } else {
            bookingMap.put(s.getType().getTypeID(), s);
        }
        session.setAttribute("bookingServices", bookingMap);
        doGet(request, response);
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
