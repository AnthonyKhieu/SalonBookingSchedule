/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Appointment;
import model.Customer;
import model.Employee;
import model.Service;
import model.ServiceType;

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
            String query1 = "Insert into Appointment\n"
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
            String query = "Select * from Appointment a\n"
                    + "inner join Customers c on a.customerID = c.customerID\n"
                    + "inner join Employees e on a.employeeID = e.employeeID\n"
                    + "where a.appointmentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Appointment a = new Appointment();
                a.setId(rs.getInt("appointmentID"));
                Employee e = new Employee();
                e.setId(rs.getInt("employeeID"));
                e.setName(rs.getString("employeeName"));
                a.setEmployee(e);
                Customer c = new Customer();
                c.setId(rs.getInt("customerID"));
                c.setName(rs.getString("customerName"));
                c.setPhone(rs.getString("phone"));
                a.setCustomer(c);
                a.setDate(rs.getDate("appointmentDate"));
                a.setDescription(rs.getString("description"));
                a.setFromHour(rs.getDouble("fromHour"));
                a.setToHour(rs.getDouble("toHour"));
                a.setServices(this.getAppointmentServices(id));
                return a;
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
        try {
            String query1 = "Select count(*) as total\n"
                    + "from Appointment a \n"
                    + "inner join Customers c on a.customerID = c.customerID\n"
                    + "inner join Employees e on a.employeeID = e.employeeID\n"
                    + "where (1=1)\n";
            ArrayList<Object> conditions = new ArrayList<>();
            if (standard.getId() != 0) {
                query1 += "and a.appointmentID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getCustomer() != null && !standard.getCustomer().getName().isEmpty()) {
                query1 += "and c.customerName like '%' + ? + '%'\n";
                conditions.add(standard.getCustomer().getName());
            }
            if (standard.getEmployee() != null && standard.getEmployee().getId() != 0) {
                query1 += "and e.employeeID = ?\n";
                conditions.add(standard.getEmployee().getId());
            }
            if (standard.getDate() != null) {
                query1 += "and a.appointmentDate = ?\n";
                conditions.add(standard.getDate());
            }
            PreparedStatement ps1 = connection.prepareStatement(query1);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps1.setInt(i, (int) o);
                } else if (o instanceof String) {
                    ps1.setString(i, (String) o);
                } else if (o instanceof Double) {
                    ps1.setDouble(i, (double) o);
                } else {
                    ps1.setDate(i, (Date) o);
                }
            }
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                return rs1.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Appointment> paginateGetting(int pageCurrent, int rowPerPage, Appointment standard) {
        ArrayList<Appointment> list = new ArrayList<>();
        try {
            String query1 = "Select e.employeeID, e.employeeName,  c.customerID, c.customerName, a.appointmentID, a.employeeID, \n"
                    + "a.customerID, a.appointmentDate, a.fromHour, a.toHour, a.description \n"
                    + "from Appointment a \n"
                    + "inner join Customers c on a.customerID = c.customerID\n"
                    + "inner join Employees e on a.employeeID = e.employeeID\n"
                    + "where (1=1)\n";
            ArrayList<Object> conditions = new ArrayList<>();
            if (standard.getId() != 0) {
                query1 += "and a.appointmentID = ?\n";
                conditions.add(standard.getId());
            }
            if (standard.getCustomer() != null && !standard.getCustomer().getName().isEmpty()) {
                query1 += "and c.customerName like '%' + ? + '%'\n";
                conditions.add(standard.getCustomer().getName());
            }
            if (standard.getEmployee() != null && standard.getEmployee().getId() != 0) {
                query1 += "and e.employeeID = ?\n";
                conditions.add(standard.getEmployee().getId());
            }
            if (standard.getDate() != null) {
                query1 += "and a.appointmentDate = ?\n";
                conditions.add(standard.getDate());
            }
            query1 += "order by a.appointmentDate asc, a.fromHour asc, e.employeeID asc\n"
                    + "offset (? - 1) * ? rows\n"
                    + "fetch next ? rows only";
       
            PreparedStatement ps1 = connection.prepareStatement(query1);
            int i = 1;
            for (; i <= conditions.size(); i++) {
                Object o = conditions.get(i - 1);
                if (o instanceof Integer) {
                    ps1.setInt(i, (int) o);
                } else if (o instanceof String) {
                    ps1.setString(i, (String) o);
                } else if (o instanceof Double) {
                    ps1.setDouble(i, (double) o);
                } else {
                    ps1.setDate(i, (Date) o);
                }
            }
            ps1.setInt(i++, pageCurrent);
            ps1.setInt(i++, rowPerPage);
            ps1.setInt(i++, rowPerPage);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                Appointment a = new Appointment();
                a.setId(rs1.getInt("appointmentID"));
                Customer c = new Customer();
                c.setId(rs1.getInt("customerID"));
                c.setName(rs1.getString("customerName"));
                a.setCustomer(c);
                Employee e = new Employee();
                e.setId(rs1.getInt("employeeID"));
                e.setName(rs1.getString("employeeName"));
                a.setEmployee(e);
                a.setFromHour(rs1.getDouble("fromHour"));
                a.setToHour(rs1.getDouble("toHour"));
                a.setDate(rs1.getDate("appointmentDate"));
                a.setDescription(rs1.getString("description"));
                a.setServices(this.getAppointmentServices(a.getId()));
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Service> getAppointmentServices(int aid) {
        ArrayList<Service> list = new ArrayList<>();
        try {
            String query = "Select s.serviceID, s.serviceName, s.time, s.price, s.typeID from AppointmentDetail ad\n"
                    + "inner join Services s on ad.serviceID = s.serviceID where ad.appointmentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, aid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("serviceID"));
                s.setName(rs.getString("serviceName"));
                s.setTime(rs.getDouble("time"));
                s.setPrice(rs.getDouble("price"));
                ServiceType st = new ServiceType();
                st.setTypeID(rs.getInt("typeID"));
                s.setType(st);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Double> getAvailableTime(double totalTime, Date picked, int eid) {
        ArrayList<Double> validTime = new ArrayList<>();
        ArrayList<String> bookedTime = new ArrayList<>();
        /*
            8    12-15   16-18     22
         */
        try {
            String query = "Select a.fromHour, a.toHour\n"
                    + "from Appointment a\n"
                    + "where a.appointmentDate = ? and a.employeeID = ?\n"
                    + "order by a.fromHour asc";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, picked);
            ps.setInt(2, eid);
            ResultSet rs = ps.executeQuery();
            double fromHour, toHour;
            while (rs.next()) {
                fromHour = rs.getDouble("fromHour");
                toHour = rs.getDouble("toHour");
                bookedTime.add(fromHour + "_" + toHour);
            }
            double start = 8;
            LocalDate today = LocalDate.now();
            LocalTime now = LocalTime.now();
            if (today.isEqual(picked.toLocalDate())) {
                if (now.getHour() >= 8) {
                    start = Math.ceil(now.getHour() + now.getMinute() / 60.0);
                }
            }
            double end = 22;
            for (String s : bookedTime) {
                String[] time = s.split("_");
                double booked_From = Double.parseDouble(time[0]);
                double booker_To = Double.parseDouble(time[1]);
                while (start + totalTime <= booked_From) {
                    validTime.add(start);
                    start += 0.5;
                }
                start = booker_To;
            }
            while (start + totalTime <= end) {
                validTime.add(start);
                start += 0.5;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDBContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return validTime;
    }
}
