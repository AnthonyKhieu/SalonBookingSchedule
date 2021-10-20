
import dal.ServiceDBContext;
import dal.ServiceTypeDBContext;
import java.util.ArrayList;
import java.util.HashMap;
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
         
        int id = 1;
        ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ServiceDBContext serviceDBC = new ServiceDBContext();
        
        Service s = serviceDBC.getByID(id);
         System.out.println(s.toString());
        
     
    }   
}
