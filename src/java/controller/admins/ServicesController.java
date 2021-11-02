/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admins;

import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServicesListController", urlPatterns = {"/service"})
public class ServicesController extends HttpServlet {

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
        Service standard = (Service) session.getAttribute("serviceModel");
        if (standard == null) {
            standard = new Service();
        }
        ServiceDBContext servDBC = new ServiceDBContext();
        String pageNo = request.getParameter("pageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        int pageCurrent = Integer.parseInt(pageNo);
        int rowPerPage = 5;
        ArrayList<Service> allServices = servDBC.paginateGetting(pageCurrent, rowPerPage, standard);
        int totalRecord = servDBC.getSize(standard);
        int totalPage = totalRecord / rowPerPage;
        if (totalRecord % rowPerPage != 0) {
            totalPage++;
        }
        ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ServiceType st_standard = new ServiceType();
        ArrayList<ServiceType> allType = servTypeDBC.getAll(servTypeDBC.getSize(st_standard));

        request.setAttribute("allType", allType);
        request.setAttribute("allServices", allServices);
        request.setAttribute("totalRecord", totalRecord);
        request.setAttribute("pageCurrent", pageCurrent);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("view/admin/serviceList.jsp").forward(request, response);
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
        Service standard = (Service) session.getAttribute("serviceModel");
        if (standard == null) {
            standard = new Service();
        }

        String searchName = request.getParameter("searchName");
        String searchType = request.getParameter("searchType");
        String searchTime = request.getParameter("searchTime");
        String searchPrice = request.getParameter("searchPrice");

        standard.setName(searchName.trim());
        if (!searchTime.isEmpty()) {
            standard.setTime(Double.parseDouble(searchTime));
        }
        else{
            standard.setTime(0);
        }
        if (!searchPrice.isEmpty()) {
            standard.setPrice(Double.parseDouble(searchPrice));
        }
        else{
            standard.setPrice(0);
        }
        ServiceType st = new ServiceType();
        st.setTypeID(Integer.parseInt(searchType));
        standard.setType(st);

        session.setAttribute("serviceModel", standard);
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
