/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Appointment;

/**
 *
 * @author Admin
 */
public class AppointmentDBContext extends DBContext implements AbsDBC<Appointment> {

    @Override
    public void insert(Appointment a) {
        try {
            String query = "Insert into Appointment \n"
                    + "values\n"
                    + "(?, ?, ?, ?, ?, ?)\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, a.getEmployee().getId());
            ps.setInt(2, a.getCustomer().getId());
            ps.setDate(3, a.getDate());
            ps.setDouble(4, a.getFrom());
            ps.setDouble(5, a.getTo());
            ps.setString(6, a.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Appointment a) {
        try {
            String query = "Update Appointment SET\n"
                    + "";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Appointment a) {
        try {
            String query = "Delete from Appointment where appointmentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, a.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Appointment getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Appointment> getAll(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Appointment> pagging(int page, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
