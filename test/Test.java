
import dal.ContactDBContext;
import dal.EmployeeDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.util.ArrayList;
import java.util.HashMap;
import model.Contact;
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

        ContactDBContext contDBC = new ContactDBContext();
        int id = 1;
        String name = "Twitter Facebook";
        String email = "ourteam@gmail.com";
        String title = "Our concern about this website";
        String detail = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        Contact c = new Contact(id, name, email, title, detail);
        
        c.setDetail("Rewrite everything");
        contDBC.update(c);

    }
}
