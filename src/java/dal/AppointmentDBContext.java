/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Appointment;
import model.Customer;
import model.Employee;
import model.Service;

/**
 *
 * @author Admin
 */
public class AppointmentDBContext extends DBContext implements AbsDBC<Appointment> {

    @Override
    public void insert(Appointment a) {
        try {
            connection.setAutoCommit(false);
            /*Insert into Appointment table*/
            String query1 = "Insert into Appointment \n"
                    + "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps1 = connection.prepareStatement(query1);
            ps1.setInt(1, a.getEmployee().getId());
            ps1.setInt(2, a.getCustomer().getId());
            ps1.setDate(3, a.getDate());
            ps1.setDouble(4, a.getFromHour());
            ps1.setDouble(5, a.getToHour());
            ps1.setString(6, a.getDescription());
            ps1.executeUpdate();

            /*Get Appointment ID*/
            String currentID = "SELECT IDENT_CURRENT('Appointment') as currentID";
            PreparedStatement ps_ID = connection.prepareStatement(currentID);
            ResultSet rs_ID = ps_ID.executeQuery();
            if (rs_ID.next()) {
                a.setId(rs_ID.getInt("currentID"));
            }
            /*Insert into AppointmentDetail table*/
            for (Service s : a.getServices()) {
                String query2 = "Insert into AppointmentDetail\n"
                        + "values(?, ?)";
                PreparedStatement ps2 = connection.prepareStatement(query2);
                ps2.setInt(1, a.getId());
                ps2.setInt(2, s.getId());
                ps2.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Appointment a) {
        try {
            connection.setAutoCommit(false);
            /*Update in Appointment table*/
            String query1 = "Update Appointment SET\n"
                    + "employeeID = ?,\n"
                    + "customerID = ?,\n"
                    + "appointmentDate = ?,\n"
                    + "fromHour = ?,\n"
                    + "toHour = ?,\n"
                    + "description = ?\n"
                    + "where appointmentID = ?\n";
            PreparedStatement ps1 = connection.prepareStatement(query1);
            ps1.setInt(1, a.getEmployee().getId());
            ps1.setInt(2, a.getCustomer().getId());
            ps1.setDate(3, a.getDate());
            ps1.setDouble(4, a.getFromHour());
            ps1.setDouble(5, a.getToHour());
            ps1.setString(6, a.getDescription());
            ps1.setInt(7, a.getId());
            ps1.executeUpdate();
            /*Update in AppointmentDetail table*/

            String query2 = "Delete from AppointmentDetail where appointmentID = ?";
            PreparedStatement ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, a.getId());
            ps2.executeUpdate();
            /*Insert new records*/
            for (Service s : a.getServices()) {
                String query3 = "Insert into AppointmentDetail "
                        + "values(?, ?)";
                PreparedStatement ps3 = connection.prepareStatement(query3);
                ps3.setInt(1, a.getId());
                ps3.setInt(2, s.getId());
                ps3.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int aid) {
        try {
            connection.setAutoCommit(false);
            /* Delete from AppointmentDetail */
            String query1 = "Delete from AppointmentDetail where appointmentID = ?";
            PreparedStatement ps1 = connection.prepareStatement(query1);
            ps1.setInt(1, aid);
            ps1.executeUpdate();
            /* Delete from Appointment*/
            String query2 = "Delete from Appointment where appointmentID = ?";
            PreparedStatement ps2 = connection.prepareStatement(query2);
            ps2.setInt(1, aid);
            ps2.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Appointment getByID(int id) {
        try {
            String query = "Select * from Appointment where appointmentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Appointment a = new Appointment();
                a.setId(rs.getInt("appointmentID"));
                Employee e = new Employee();
                e.setId(rs.getInt("employeeID"));
                a.setEmployee(e);
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                a.setCustomer(c);
                a.setDate(rs.getDate("appointmentDate"));
                a.setDescription(rs.getString("description"));
                a.setFromHour(rs.getDouble("fromHour"));
                a.setToHour(rs.getDouble("toHour"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Appointment> getAll(int number) {
        ArrayList<Appointment> list = new ArrayList<>();
        try {
            String query = "Select top(?) * from Appointment where appointmentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setId(rs.getInt("appointmentID"));
                Employee e = new Employee();
                e.setId(rs.getInt("employeeID"));
                a.setEmployee(e);
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                a.setCustomer(c);
                a.setDate(rs.getDate("appointmentDate"));
                a.setDescription(rs.getString("description"));
                a.setFromHour(rs.getDouble("fromHour"));
                a.setToHour(rs.getDouble("toHour"));
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public int getSize(Appointment standard) {
        return 0;
    }

    @Override
    public ArrayList<Appointment> paginateGetting(int page, int row, Appointment standard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public ArrayList<Double> getAvailableTime(double totalTime, Time today){
//        ArrayList<Double> todaySchedule = new ArrayList<>();
//        try {
//            ArrayList<Double> availableHour = new ArrayList<>();
//            String query = "Select fromHour from Appointment";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                availableHour.add(rs.getDouble("fromHour"));
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    }
}
