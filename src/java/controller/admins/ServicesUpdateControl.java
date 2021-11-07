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
@WebServlet(name = "ServicesUpdateControl", urlPatterns = {"/admin/updateServices"})
public class ServicesUpdateControl extends BaseModelAuthentication{

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
        int sid = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String price = request.getParameter("price");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String old_images = request.getParameter("old_images");
        String new_images = request.getParameter("new_images");

        Service s = new Service();
        s.setId(sid);
        s.setName(name);
        if (new_images != null && new_images.length() != 0) {
            s.setImages(new_images);
        } else {
            s.setImages(old_images);
        }
        s.setPrice(Double.parseDouble(price));
        s.setTime(Double.parseDouble(time));
        s.setDescription(description);
        ServiceType st = new ServiceType();
        st.setTypeID(Integer.parseInt(type));
        s.setType(st);

        servDBC.update(s);
        String url=request.getHeader("Referer");
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
