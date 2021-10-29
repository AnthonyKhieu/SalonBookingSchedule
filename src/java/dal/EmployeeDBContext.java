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
import model.Customer;
import model.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeDBContext extends DBContext implements AbsDBC<Employee> {

    @Override
    public void insert(Employee e) {
        try {
            String query = "Insert into Employees values"
                    + "(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, e.getName());
            ps.setString(2, e.getInsta());
            ps.setString(3, e.getDescription());
            ps.setString(4, e.getImages());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Employee e) {
        try {
            String query = "Update Employees set\n"
                    + "employeeName = ?,\n"
                    + "insta = ? ,\n"
                    + "description = ? ,\n"
                    + "images = ? \n"
                    + "where employeeID = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, e.getName());
            ps.setString(2, e.getInsta());
            ps.setString(3, e.getDescription());
            ps.setString(4, e.getImages());
            ps.setInt(5, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(int eid) {
        try {
            String query = "Delete Employees where employeeID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, eid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public int getSize(Employee standard) {
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select count(*) as total \n"
                    + "from Employees\n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and employeeID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and employeeName like '%' + ? + '%' \n";
                conditions.add(standard.getName());
            }
            PreparedStatement ps = connection.prepareStatement(query);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps.setInt(i, (int) o);
                } else {
                    ps.setString(i, (String) o);
                }
            }
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Employee> paginateGetting(int pageCurrent, int rowPerPage, Employee standard) {
        ArrayList<Employee> list = new ArrayList();
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select * \n"
                    + "from Employees\n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and employeeID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and employeeName like '%' + ? + '%' \n";
                conditions.add(standard.getName());
            }
            query += "order by employeeID asc\n"
                    + "offset (? - 1) * ? rows\n"
                    + "fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps.setInt(i, (int) o);
                } else {
                    ps.setString(i, (String) o);
                }
            }
            ps.setInt(i++, pageCurrent);
            ps.setInt(i++, rowPerPage);
            ps.setInt(i++, rowPerPage);
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
