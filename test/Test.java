
import dal.AccountDBContext;
import dal.AppointmentDBContext;
import dal.CustomerDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.sql.Date;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
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
        AppointmentDBContext db = new AppointmentDBContext();
        Appointment a = new Appointment();
        String s = "";

//        a.setFromHour(8);
//        a.setToHour(12);
//        
        Customer c = new Customer();
        a.setCustomer(c);

//        Employee e = new Employee();
//        e.setId(4);
//        a.setEmployee(e);
//        
//        a.setDescription("New one");
//        
//        Service s1 = new Service();
//        s1.setId(1);
//        Service s2 = new Service();
//        s2.setId(15);
//        a.getServices().add(s1);
//        a.getServices().add(s2);
//        db.insert(a);
        AccountDBContext dbd = new AccountDBContext();
        String username = "mr1";
        String password = "12345";
        System.out.println(dbd.getAccount(username, password));
    }
}
