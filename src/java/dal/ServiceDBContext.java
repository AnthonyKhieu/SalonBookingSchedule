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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
public class ServiceDBContext extends DBContext implements AbsDBC<Service> {

    @Override
    public void insert(Service s) {
        try {
            String query = "Insert into Employees values"
                    + "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getImages());
            ps.setDouble(4, s.getPrice());
            ps.setInt(5, s.getOrdered());
            ps.setString(6, s.getDescription());
            ps.setDouble(7, s.getPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Service s) {
        try {
            String query = "Update Services set\n"
                    + "typeID = ?,\n"
                    + "serviceName = ?,\n"
                    + "images = ?,\n"
                    + "time = ?,\n"
                    + "ordered = ?,\n"
                    + "description = ?,\n"
                    + "price = ?\n"
                    + "where serviceID = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getImages());
            ps.setDouble(4, s.getPrice());
            ps.setInt(5, s.getOrdered());
            ps.setString(6, s.getDescription());
            ps.setDouble(7, s.getPrice());
            ps.setInt(8, s.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Service s) {
        try {
            String query = "Delete from Services where serviceID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, s.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Service> getAll(int number) {
        ArrayList<Service> list = new ArrayList();
        try {
            String query = "Select top (?) * from "
                    + "Services s inner join ServiceType st on s.typeID = st.typeID "
                    + "order by ordered desc, time asc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("serviceID"));
                s.setName(rs.getString("serviceName"));
                s.setImages(rs.getString("images"));
                s.setTime(rs.getDouble("time"));
                s.setOrdered(rs.getInt("ordered"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                ServiceType st = new ServiceType();
                st.setTypeID(rs.getInt("typeID"));
                st.setTypeName(rs.getString("typeName"));
                s.setType(st);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Service getByID(int id) {
        try {
            String query = "Select * from "
                    + "Services s inner join ServiceType st on s.typeID = st.typeID "
                    + "where serviceID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("serviceID"));
                s.setName(rs.getString("serviceName"));
                s.setImages(rs.getString("images"));
                s.setTime(rs.getDouble("time"));
                s.setOrdered(rs.getInt("ordered"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                ServiceType st = new ServiceType();
                st.setTypeID(rs.getInt("typeID"));
                st.setTypeName(rs.getString("typeName"));
                s.setType(st);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getSize() {
        try {
            String query = "Select count(*) as total from Services ";
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

    public ArrayList<Service> getServiceByType(ServiceType st) {
        ArrayList<Service> list = new ArrayList();
        try {
            String query = "Select * from "
                    + "Services s inner join ServiceType st on s.typeID = st.typeID "
                    + "order by ordered desc, time asc";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int st_id = rs.getInt("typeID");
                if (st_id == st.getTypeID()) {
                    Service s = new Service();
                    s.setId(rs.getInt("serviceID"));
                    s.setName(rs.getString("serviceName"));
                    s.setImages(rs.getString("images"));
                    s.setTime(rs.getDouble("time"));
                    s.setOrdered(rs.getInt("ordered"));
                    s.setPrice(rs.getDouble("price"));
                    s.setDescription(rs.getString("description"));
                    s.setType(st);
                    list.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<Service> pagging(int page, int row) {
        ArrayList<Service> list = new ArrayList();
        try {
            String query = "Select * \n"
                    + "from Service\n"
                    + "order by id asc\n"
                    + "offset (? - 1) * ? rows\n"
                    + "fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, page);
            ps.setInt(2, row);
            ps.setInt(3, row);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("serviceID"));
                s.setName(rs.getString("serviceName"));
                s.setImages(rs.getString("images"));
                s.setTime(rs.getDouble("time"));
                s.setOrdered(rs.getInt("ordered"));
                s.setPrice(rs.getDouble("price"));
                s.setDescription(rs.getString("description"));
                ServiceType st = new ServiceType();
                st.setTypeID(rs.getInt("typeID"));
                st.setTypeName(rs.getString("typeName"));
                s.setType(st);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

