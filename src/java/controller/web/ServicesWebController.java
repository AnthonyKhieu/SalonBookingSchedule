/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.web;

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
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServicesController", urlPatterns = {"/servicesWeb"})
public class ServicesWebController extends HttpServlet {

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
        ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ServiceType st_standard = new ServiceType();
        ArrayList<ServiceType> allType = servTypeDBC.getAll(servTypeDBC.getSize(st_standard));
        request.setAttribute("servType", allType);

        ServiceDBContext serviceDBC = new ServiceDBContext();
        
        HashMap<ServiceType, ArrayList<Service>> serv_map = new HashMap();
        for(ServiceType st : allType){
            ArrayList<Service> list = serviceDBC.getServiceByType(st.getTypeID());
            serv_map.put(st, list);
        }
        
        request.setAttribute("mappingServices", serv_map);
        request.getRequestDispatcher("view/web/services.jsp").forward(request, response);
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
