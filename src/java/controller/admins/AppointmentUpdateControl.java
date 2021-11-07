/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import dal.AppointmentDBContext;
import dal.EmployeeDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Appointment;
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AppointmentUpdateControl", urlPatterns = {"/admin/updateAppointment"})
public class AppointmentUpdateControl extends HttpServlet {

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
        int aid = Integer.parseInt(request.getParameter("aid"));
        AppointmentDBContext aptDBC = new AppointmentDBContext();
        ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ServiceType st_standard = new ServiceType();
        ArrayList<ServiceType> allType = servTypeDBC.getAll(servTypeDBC.getSize(st_standard));
        ServiceDBContext servDBC = new ServiceDBContext();

        HashMap<ServiceType, ArrayList<Service>> serv_map = new HashMap();
        for (ServiceType st : allType) {
            ArrayList<Service> list = servDBC.getServiceByType(st.getTypeID());
            serv_map.put(st, list);
        }

        Appointment a = aptDBC.getByID(aid);
        double totalTime = a.getToHour() - a.getFromHour();

        session.setAttribute("appointment", a);
        request.setAttribute("avalTime", aptDBC.getAvailableTime(totalTime, a.getDate(), a.getEmployee().getId()));
        request.setAttribute("totalTime", totalTime);
        request.setAttribute("mappingServices", serv_map);
        request.setAttribute("serviceType", allType);
        request.getRequestDispatcher("../view/admin/appointmentDetail.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Appointment a = (Appointment) session.getAttribute("appointment");
        if (a == null) {
            a = new Appointment();
        }
        ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ServiceType st_standard = new ServiceType();
        ServiceDBContext servDBC = new ServiceDBContext();
        ArrayList<ServiceType> allType = servTypeDBC.getAll(servTypeDBC.getSize(st_standard));
        ArrayList<Service> services = new ArrayList<>();
        AppointmentDBContext aptDBC = new AppointmentDBContext();
        for(ServiceType st : allType){
            int sid = Integer.parseInt(request.getParameter("booked" + st.getTypeID()));
            if(sid != 0){
                services.add(servDBC.getByID(sid));
            }
        }
        a.setServices(services);
        aptDBC.update(a);
        response.sendRedirect("appointment");
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
