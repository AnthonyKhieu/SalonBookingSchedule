/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeDBContext extends DBContext implements AbsDBC<Employee>{

    @Override
    public void add(Employee e) {
    }

    @Override
    public void update(Employee e) {
    }

    @Override
    public void delete(Employee e) {
    }

    @Override
    public ArrayList<Employee> getAll() {
        return null;
    }


    
}
