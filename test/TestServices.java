
import dal.ServiceDBContext;
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
public class TestServices {
    public static void main(String[] args) {
        ServiceDBContext servDBC = new ServiceDBContext();
        Service s = new Service();
        ServiceType st = new ServiceType();
        st.setTypeID(1);
        s.setType(st);
        System.out.println(servDBC.getSize(s));
    }
}
