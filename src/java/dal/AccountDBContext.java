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
import model.Feature;

/**
 *
 * @author Admin
 */
public class AccountDBContext extends DBContext {

    public void insert(String username, String password, int groupid) {
        try {
            String query = "Insert into Account values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            String query2 = "Insert into GroupAccount values(?, ?)";
            PreparedStatement ps2 = connection.prepareStatement(query2);
            ps2.setString(1, username);
            ps2.setInt(2, groupid);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Account a) {
        try {
            String query = "Update Account SET\n"
                    + "password = ?\n"
                    + "where username = ?\n";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, a.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String username) {
        try {
            String query = "Delete from Account where username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccount(String username, String password) {
        try {
            String query = "SELECT a.username,a.password,\n"
                    + "f.fid,f.url\n"
                    + "FROM Account a LEFT JOIN GroupAccount ga\n"
                    + "ON a.username = ga.username\n"
                    + "LEFT JOIN [Group] g ON g.gid = ga.gid\n"
                    + "LEFT JOIN [GroupFeature] gf ON gf.gid = g.gid\n"
                    + "LEFT JOIN [Feature] f ON f.fid = gf.fid\n"
                    + "WHERE a.username = ? AND a.password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Account a = null;
            while (rs.next()) {
                if (a == null) {
                    a = new Account();
                    a.setUsername(rs.getString("username"));
                    a.setPassword(rs.getString("password"));
                }
                int fid = rs.getInt("fid");
                if (fid != 0) {
                    Feature f = new Feature();
                    f.setFid(fid);
                    f.setUrl(rs.getString("url"));
                    a.getFeatures().add(f);
                }
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean isExist(String username){
        try {
            String query = "Select * from Account where username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
