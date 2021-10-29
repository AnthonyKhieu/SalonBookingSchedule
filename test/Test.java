
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
        ServiceDBContext servDBC = new ServiceDBContext();

        Service s = new Service();
        s.setId(41);
        s.setName("Mulfafafaf");

        s.setTime(200);
        s.setPrice(30);
        s.setImages("dadasdasdasdasdasdas");
        s.setDescription("dadasda");
        ServiceType st = new ServiceType();
        st.setTypeID(1);
        
        s.setType(st);
        servDBC.update(s);
    }
}
