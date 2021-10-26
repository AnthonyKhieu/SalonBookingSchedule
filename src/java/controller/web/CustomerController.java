/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.web;

import dal.CustomerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/customer"})
public class CustomerController extends HttpServlet {

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
        Customer standard = (Customer) session.getAttribute("searchModel");
        if (standard == null) {
            standard = new Customer();
        }
        CustomerDBContext cusDBC = new CustomerDBContext();
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        int pageCurrent = Integer.parseInt(pageNo);
        int rowPerPage = 5;
        ArrayList<Customer> allCustomers = cusDBC.paginateGetting(pageCurrent, rowPerPage, standard);
        int totalRecord = cusDBC.getSize(standard);
        int totalPage = totalRecord / rowPerPage;
        if (totalRecord % rowPerPage != 0) {
            totalPage++;
        }
        request.setAttribute("allCustomer", allCustomers);
        request.setAttribute("rowPerPage", rowPerPage);
        request.setAttribute("pageCurrent", pageCurrent);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("view/admin/customer.jsp").forward(request, response);
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
        Customer standard = (Customer) session.getAttribute("searchModel");
        if (standard == null) {
            standard = new Customer();
        }
        String searchName = request.getParameter("searchName");
        standard.setName(searchName.trim());
        String searchPhone = request.getParameter("searchPhone");
        standard.setPhone(searchPhone.trim());
        session.setAttribute("searchModel", standard);
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
