/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/updateEmployee"})
public class EmployeeUpdateController extends HttpServlet {

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
        int eid = Integer.parseInt(request.getParameter("eid"));
        String name = request.getParameter("name");
        String insta = request.getParameter("insta");
        String old_images = request.getParameter("old_images");
        String new_images = request.getParameter("new_images");
        String description = request.getParameter("description");
        Employee e = new Employee();
        e.setId(eid);
        if(name != null && !name.isEmpty()){
            e.setName(name);
        }
        if(insta != null){
            e.setInsta(insta);
        }
        if(description != null){
            e.setDescription(description);
        }
        
        if(new_images != null && new_images.length() != 0){
            e.setImages(new_images);
        }
        else{
            e.setImages(old_images);
        }
        
        EmployeeDBContext empDBC = new EmployeeDBContext();
        empDBC.update(e);
        response.sendRedirect("employee");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
