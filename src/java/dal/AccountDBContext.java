/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void insert(Account a) {
        try {
            String query = "Insert into Account values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setInt(3, a.getRole());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Account a) {
        try {
            String query = "Update Account SET\n"
                    + "username = ?\n"
                    + "password = ?\n"
                    + "role = ?\n"
                    + "where accountID = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int aid) {
        try {
            String query = "Delete from Account where accountID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, aid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Account getByID(int id) {
        try {
            String query = "Select * from Account where accountID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Account a = new Account();
                a.setId(id);
                a.setUsername("username");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Account> getAll(int number) {
        return null;
    }


    @Override
    public int getSize(Account standard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Account> paginateGetting(int page, int row, Account standard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
