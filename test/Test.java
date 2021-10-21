
import dal.EmployeeDBContext;
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.util.ArrayList;
import java.util.HashMap;
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
         
        EmployeeDBContext db = new EmployeeDBContext();
        for(Employee e : db.getAll(db.getSize())){
            System.out.println(e.getId() + e.getImages());
        }

        
     
    }   
}
