
import dal.AppointmentDBContext;
import dal.CustomerDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import model.Appointment;
import model.Customer;
import model.Employee;
import model.Service;
import model.ServiceType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Test {

    public static void main(String[] args) {
//        AppointmentDBContext appDBC = new AppointmentDBContext();
//        Appointment a = new Appointment();
//        a.setId(5);
//        
//        Customer c = new Customer();
//        c.setId(1);
//        a.setCustomer(c);
//        
//        Employee e = new Employee();
//        e.setId(1);
//        a.setEmployee(e);
//        
//        a.setDate(Date.valueOf("2001-01-01"));
//        a.setFromHour(10.30);
//        a.setToHour(12.00);
//        
//        a.setDescription("Close look");
//        
//        Service s = new Service();
//        s.setId(1);
//        Service s2 = new Service();
//        s2.setId(2);
//        a.getServices().add(s);
//        a.getServices().add(s2);
        
        CustomerDBContext cusDBC = new CustomerDBContext();


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println(map.get(2) == null);
    }
}
