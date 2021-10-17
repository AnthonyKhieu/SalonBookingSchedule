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
public class ServiceDBContext extends DBContext implements AbsDBC<Service> {

    @Override
    public void add(Service s) {
       
    }

    @Override
    public void update(Service s) {
       
    }

    @Override
    public void delete(Service s) {
        
    }

    @Override
    public ArrayList<Service> getAll() {
        ArrayList<Service> list = new ArrayList();
        try {
            String query = "Select * from Services s inner join ServiceType st on s.typeID = st.typeID";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
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
                st.setIsMain(rs.getBoolean("isMain"));
                s.setType(st);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

}
