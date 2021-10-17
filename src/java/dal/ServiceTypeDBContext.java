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
    public ArrayList<ServiceType> getAll() {
        ArrayList<ServiceType> list = new ArrayList();
        try {
            String query = "Select * from ServiceType";
            PreparedStatement ps = connection.prepareStatement(query);
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

}
