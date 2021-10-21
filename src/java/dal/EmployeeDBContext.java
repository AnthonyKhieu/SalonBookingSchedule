/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Service;

/**
 *
 * @author Admin
 */
public class EmployeeDBContext extends DBContext implements AbsDBC<Employee> {

    @Override
    public void add(Employee e) {
    }

    @Override
    public void update(Employee e) {
    }

    @Override
    public void delete(Employee e) {
    }

    @Override
    public Employee getByID(int id) {

        try {
            String query = "Select * from Employees where employeeID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("employeeID"));
                e.setName(rs.getString("employeeName"));
                e.setInsta(rs.getString("insta"));
                e.setImages(rs.getString("images"));
                e.setDescription(rs.getString("description"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public int getSize() {
        try {
            String query = "Select count(*) as total from Employees ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Employee> getAll(int number) {
        ArrayList<Employee> list = new ArrayList();
        try {
            String query = "Select top (?) * from Employees";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("employeeID"));
                e.setName(rs.getString("employeeName"));
                e.setInsta(rs.getString("insta"));
                e.setImages(rs.getString("images"));
                e.setDescription(rs.getString("description"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
