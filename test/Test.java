
import dal.ContactDBContext;
import dal.CustomerDBContext;
import dal.EmployeeDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.util.ArrayList;
import java.util.HashMap;
import model.Contact;
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

        CustomerDBContext cusDBC = new CustomerDBContext();
        Customer standard = new Customer();
        standard.setName(null);
        standard.setPhone(null);
        System.out.println(cusDBC.getSize(standard));
    }
}
