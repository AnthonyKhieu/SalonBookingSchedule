/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import controller.auth.BaseModelAuthentication;
import dal.AppointmentDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;
import model.Customer;
import model.Employee;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AppointmentController", urlPatterns = {"/admin/appointment"})
public class AppointmentController extends BaseModelAuthentication {

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
        HttpSession session = request.getSession();
        Appointment standard = (Appointment) session.getAttribute("appointmentModel");
        if (standard == null) {
            standard = new Appointment();
        }
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        AppointmentDBContext aptDBC = new AppointmentDBContext();
        EmployeeDBContext empDBC = new EmployeeDBContext();
        Employee e = new Employee();
        int pageCurrent = Integer.parseInt(pageNo);
        int rowPerPage = 5;
        ArrayList<Appointment> allAppointments = aptDBC.paginateGetting(pageCurrent, rowPerPage, standard);
        int totalRecord = aptDBC.getSize(standard);
        int totalPage = totalRecord / rowPerPage;
        if (totalRecord % rowPerPage != 0) {
            totalPage++;
        }
        if (totalRecord == 0) {
            totalPage = 0;
            pageCurrent = 0;
        }
        request.setAttribute("allAppointments", allAppointments);
        request.setAttribute("allEmployees", empDBC.getAll(empDBC.getSize(e)));
        request.setAttribute("totalRecord", totalRecord);
        request.setAttribute("pageCurrent", pageCurrent);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("../view/admin/appointmentList.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Appointment standard = (Appointment) session.getAttribute("appointmentModel");
        if (standard == null) {
            standard = new Appointment();
        }
        String searchCustomer = request.getParameter("searchCustomer");
        String searchEmployee = request.getParameter("searchEmployee");
        String searchDate = request.getParameter("searchDate");

        Customer c = new Customer();
        c.setName(searchCustomer);
        standard.setCustomer(c);

        Employee e = new Employee();
        e.setId(Integer.parseInt(searchEmployee));
        standard.setEmployee(e);

        if (!searchDate.isEmpty()) {
            standard.setDate(Date.valueOf(searchDate));
        }
        else{
            standard.setDate(null);
        }

        session.setAttribute("appointmentModel", standard);
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
