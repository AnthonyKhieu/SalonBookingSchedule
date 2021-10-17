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
    public void add(Appointment a) {
        try {
            String query = "Insert into Appointment \n"
                    + "values\n"
                    + "( ?, ?, ?, ?, ?, ?)\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Appointment m) {

    }

    @Override
    public void delete(Appointment m) {
    }

    @Override
    public ArrayList<Appointment> getAll() {
        return null;
    }

}
