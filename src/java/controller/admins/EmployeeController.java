/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import controller.auth.BaseModelAuthentication;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employee;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/admin/employee"})
public class EmployeeController extends BaseModelAuthentication {

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
        Employee standard = (Employee) session.getAttribute("employeeModel");
        if (standard == null) {
            standard = new Employee();
        }
        EmployeeDBContext empDBC = new EmployeeDBContext();
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        int pageCurrent = Integer.parseInt(pageNo);
        int rowPerPage = 5;
        ArrayList<Employee> allEmployees = empDBC.paginateGetting(pageCurrent, rowPerPage, standard);
        int totalRecord = empDBC.getSize(standard);
        int totalPage = totalRecord / rowPerPage;
        if (totalRecord % rowPerPage != 0) {
            totalPage++;
        }
        request.setAttribute("allEmployees", allEmployees);
        request.setAttribute("totalRecord", totalRecord);
        request.setAttribute("pageCurrent", pageCurrent);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("../view/admin/employeeList.jsp").forward(request, response);
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
        Employee standard = (Employee) session.getAttribute("employeeModel");
        if (standard == null) {
            standard = new Employee();
        }
        String searchName = request.getParameter("searchName");
        standard.setName(searchName.trim());
        session.setAttribute("employeeModel", standard);
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
