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
import model.Service;
import model.ServiceType;

/**
 *
 * @author Admin
 */
public class ServiceTypeDBContext extends DBContext implements AbsDBC<ServiceType> {

    @Override
    public void insert(ServiceType st) {
        try {
            String query = "Insert into ServiceType values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, st.getTypeID());
            ps.setString(2, st.getTypeName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ServiceType st) {
        try {
            String query = "Update ServiceType SET\n"
                    + "typeName = ?\n"
                    + "where typeID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, st.getTypeName());
            ps.setInt(2, st.getTypeID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int stId) {
        try {
            String query = "Delete from ServiceType where typeID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ServiceType> getAll(int number) {
        ArrayList<ServiceType> list = new ArrayList();
        try {
            String query = "Select top (?) * from ServiceType";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ServiceType st = new ServiceType();
                st.setTypeID(rs.getInt("typeID"));
                st.setTypeName(rs.getString("typeName"));
                list.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ServiceType getByID(int id) {
        try {
            String query = "Select * from ServiceType where typeID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ServiceType st = new ServiceType();
                st.setTypeID(id);
                st.setTypeName(rs.getString("typeName"));
                return st;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getSize(ServiceType standard) {
        try {
            ArrayList<Object> conditions = new ArrayList();
            String query = "Select count(*) as total \n"
                    + "from ServiceType\n"
                    + "where(1=1)\n";
            if (standard.getTypeID() != 0) {
                query += "and typeID = ?\n";
                conditions.add(standard.getTypeID());
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
            Logger.getLogger(ServiceTypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<ServiceType> paginateGetting(int page, int row, ServiceType standard) {
        return null;
    }

}
