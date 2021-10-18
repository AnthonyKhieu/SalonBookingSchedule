
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
          ServiceTypeDBContext servTypeDBC = new ServiceTypeDBContext();
        ArrayList<ServiceType> servType = servTypeDBC.getAll(servTypeDBC.getSize());

        ServiceDBContext serviceDBC = new ServiceDBContext();
        ArrayList<Service> allServices = serviceDBC.getAll(serviceDBC.getSize());

        HashMap<ServiceType, ArrayList<Service>> serv_map = new HashMap();
        for (Service s : allServices) {
            for (ServiceType st : servType) {
                if (serv_map.get(st) == null) {
                    ArrayList<Service> thisServices = new ArrayList<>();
                    serv_map.put(st, thisServices);
                }
                if(s.getType().getTypeID() == st.getTypeID()){
                    serv_map.get(st).add(s);
                }
            }
        }
        
        for(ServiceType st : serv_map.keySet()){
            ArrayList<Service> list = serv_map.get(st);
            for(Service s : list){
                System.out.println(s.getId() + " " + s.getName() + " " +  s.getTime() + " " + s.getPrice());
            }
        }
    }
}
