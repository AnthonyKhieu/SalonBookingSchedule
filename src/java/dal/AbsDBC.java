/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import model.AbsModel;


/**
 *
 * @author Admin
 * @param <Model>
 */

public interface AbsDBC<Model extends AbsModel> {
    void add(Model m);
    
    void update(Model m);
    
    void delete(Model m);
    
    ArrayList<Model> getAll();
}
