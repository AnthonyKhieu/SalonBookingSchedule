/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import controller.auth.BaseModelAuthentication;
import dal.ServiceDBContext;
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
@WebServlet(name = "ServicesCreateControl", urlPatterns = {"/admin/createServices"})
public class ServicesCreateControl extends BaseModelAuthentication {

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
        ServiceDBContext servDBC = new ServiceDBContext();
        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String price = request.getParameter("price");
        String images = request.getParameter("images");
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        Service s = new Service();
        s.setName(name);
        s.setImages(images);
        s.setPrice(Double.parseDouble(price));
        s.setTime(Double.parseDouble(time));
        s.setOrdered(0);
        s.setDescription(description);
        ServiceType st = new ServiceType();
        st.setTypeID(Integer.parseInt(type));
        s.setType(st);

        servDBC.insert(s);
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
