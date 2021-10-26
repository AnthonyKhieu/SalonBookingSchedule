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

/**
 *
 * @author Admin
 */
public class CustomerDBContext extends DBContext implements AbsDBC<Customer> {

    @Override
    public void insert(Customer c) {
        try {
            String query = "Insert into Customers values"
                    + "(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Customer c) {
        try {
            String query = "Update Customers set\n"
                    + "customerName = ?,\n"
                    + "phone = ?,\n"
                    + "description = ?\n"
                    + "where customerID = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getDescription());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "Delete from Customers where customerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Customer getByID(int id) {
        try {
            String query = "Select * from Customers where customerID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                c.setName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                c.setDescription(rs.getString("description"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getSize(Customer standard) {
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select count(*) as total \n"
                    + "from Customers\n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and customerID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and customerName like '%' + ? + '%'\n";
                conditions.add(standard.getName());
            }
            if (standard.getPhone() != null) {
                query += "and phone like '%' + ? + '%'\n";
                conditions.add(standard.getPhone());
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
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Customer> getAll(int number) {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            String query = "Select top (?) * from Customers";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                c.setName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<Customer> paginateGetting(int pageCurrent, int rowPerPage, Customer standard) {
        ArrayList<Customer> list = new ArrayList();
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select * \n"
                    + "from Customers\n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and customerID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and customerName like '%' + ? + '%' \n";
                conditions.add(standard.getName());
            }
            if (standard.getPhone() != null) {
                query += "and phone like '%' + ? + '%'\n";
                conditions.add(standard.getPhone());
            }
            query += "order by customerID asc\n"
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
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                c.setName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Customer getByPhoneNumber(String phone) {
        try {
            String query = "Select * from Customers where phone = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                c.setName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                c.setDescription(rs.getString("description"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
