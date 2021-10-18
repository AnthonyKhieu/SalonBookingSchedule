/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDBContext extends DBContext implements AbsDBC<Account> {

    @Override
    public void add(Account a) {
        try {
            String query = "";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Account a) {
        
    }

    @Override
    public void delete(Account a) {
        
    }

    @Override
    public ArrayList<Account> getAll() {
        return null;
    }

    @Override
    public Account getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
