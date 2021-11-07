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
@WebServlet(name = "ServiceTypeController", urlPatterns = {"/serviceTypeWeb"})
public class ServiceTypeWebController extends HttpServlet {

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
        int st_id = Integer.parseInt(request.getParameter("st_id"));
        ServiceDBContext servDBC = new ServiceDBContext();
        ServiceTypeDBContext typeDBC = new ServiceTypeDBContext();
        ServiceType st = typeDBC.getByID(st_id);
        request.setAttribute("serviceType", st);
        request.setAttribute("serviceList", servDBC.getServiceByType(st.getTypeID()));
        request.getRequestDispatcher("view/web/serviceListDetail.jsp").forward(request, response);
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
                String name = request.getParameter("name");
        ServiceDBContext servDBC = new ServiceDBContext();
        Service standard = new Service();
        standard.setName(name);   
        request.setAttribute("name", name);
        request.setAttribute("serviceList", servDBC.paginateGetting(1, servDBC.getSize(standard), standard));
        request.getRequestDispatcher("view/web/serviceListDetail.jsp").forward(request, response);
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
