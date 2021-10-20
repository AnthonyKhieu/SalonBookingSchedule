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
    public void add(ServiceType st) {
    }

    @Override
    public void update(ServiceType st) {
    }

    @Override
    public void delete(ServiceType st) {
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
            if(rs.next()){
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
    public int getSize() {
        try {
            String query = "Select count(*) as total from ServiceType ";
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


}
