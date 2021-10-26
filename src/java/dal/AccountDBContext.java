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
    public void delete(Account a) {
        try {
            String query = "Delete from Account where accountID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, a.getId());
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
    }

    @Override
    public int getSize() {
    }

    @Override
    public ArrayList<Account> getAll(int number) {
    }

    @Override
    public ArrayList<Account> pagging(int page, int row) {
    }

    @Override
    public Account searchByName(String name) {
    }

    @Override
    public ArrayList<Account> multiSearch(Account m) {
    }

}
