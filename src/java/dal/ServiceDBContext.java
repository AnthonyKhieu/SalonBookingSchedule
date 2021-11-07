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
            String query = "Insert into Services values"
                    + "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, s.getType().getTypeID());
            ps.setString(2, s.getName());
            ps.setString(3, s.getImages());
            ps.setDouble(4, s.getTime());
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
                    + "description = ?,\n"
                    + "price = ?\n"
                    + "where serviceID = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, s.getType().getTypeID());
            ps.setString(2, s.getName());
            ps.setString(3, s.getImages());
            ps.setDouble(4, s.getTime());
            ps.setString(5, s.getDescription());
            ps.setDouble(6, s.getPrice());
            ps.setInt(7, s.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(int sid) {
        try {
            String query = "Delete from Services where serviceID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sid);
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

    public ArrayList<Service> getServiceByType(int typeID) {
        ArrayList<Service> list = new ArrayList();
        try {
            String query = "Select * from "
                    + "Services s inner join ServiceType st on s.typeID = st.typeID "
                    + "where s.typeID = ? "
                    + "order by ordered desc, time asc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, typeID);
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
                st.setTypeID(typeID);
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
    public int getSize(Service standard) {
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select count(*) as total \n"
                    + "from Services\n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and serviceID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and serviceName like '%' + ? + '%' \n";
                conditions.add(standard.getName());
            }
            if (standard.getTime() != 0) {
                query += "and time <= ?\n";
                conditions.add(standard.getTime());
            }
            if (standard.getPrice() != 0) {
                query += "and price <= ?\n";
                conditions.add(standard.getPrice());
            }
            if (standard.getType() != null && standard.getType().getTypeID() != 0) {
                query += "and typeID = ?";
                conditions.add(standard.getType().getTypeID());
            }
            PreparedStatement ps = connection.prepareStatement(query);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps.setInt(i, (int) o);
                } else if (o instanceof String) {
                    ps.setString(i, (String) o);
                } else {
                    ps.setDouble(i, (double) o);
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
    public ArrayList<Service> paginateGetting(int pageCurrent, int rowPerPage, Service standard) {
        ArrayList<Service> list = new ArrayList();
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select * \n"
                    + "from Services s inner join ServiceType st on s.typeID = st.typeID \n"
                    + "where(1=1)\n";
            if (standard.getId() != 0) {
                query += "and serviceID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getName() != null) {
                query += "and serviceName like '%' + ? + '%' \n";
                conditions.add(standard.getName());
            }
            if (standard.getType() != null && standard.getType().getTypeID() != 0) {
                query += "and s.typeID = ? \n";
                conditions.add(standard.getType().getTypeID());
            }
            if (standard.getTime() != 0) {
                query += "and time <= ?\n";
                conditions.add(standard.getTime());
            }
            if (standard.getPrice() != 0) {
                query += "and price <= ?\n";
                conditions.add(standard.getPrice());
            }

            query += "order by s.typeID asc, ordered desc, time asc\n"
                    + "offset (? - 1) * ? rows\n"
                    + "fetch next ? rows only";
            PreparedStatement ps = connection.prepareStatement(query);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps.setInt(i, (int) o);
                } else if (o instanceof String) {
                    ps.setString(i, (String) o);
                } else {
                    ps.setDouble(i, (double) o);
                }
            }
            ps.setInt(i++, pageCurrent);
            ps.setInt(i++, rowPerPage);
            ps.setInt(i++, rowPerPage);
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
                s.setType(st);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
