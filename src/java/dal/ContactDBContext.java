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
import model.Contact;

/**
 *
 * @author Admin
 */
public class ContactDBContext extends DBContext implements AbsDBC<Contact> {

    @Override
    public void insert(Contact c) {
        try {
            String query = "Insert into Contact values"
                    + "(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTitle());
            ps.setString(4, c.getDetail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Contact c) {
        try {
            String query = "Update Contact set \n"
                    + "contactName = ?,\n"
                    + "email = ?,\n"
                    + "title = ?,\n"
                    + "detail = ?\n"
                    + "where contactID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTitle());
            ps.setString(4, c.getDetail());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int cid) {
        try {
            String query = "Delete from Contact where contactID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Contact getByID(int id) {
        try {
            String query = "Select * from Contact where contactID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt("contactID"));
                c.setName(rs.getString("contactName"));
                c.setEmail(rs.getString("email"));
                c.setTitle(rs.getString("title"));
                c.setDetail(rs.getString("detail"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Contact> getAll(int number) {
        ArrayList<Contact> list = new ArrayList();
        try {
            String query = "Select * from Contact";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt("contactID"));
                c.setName(rs.getString("contactName"));
                c.setEmail(rs.getString("email"));
                c.setTitle(rs.getString("title"));
                c.setDetail(rs.getString("detail"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getSize(Contact standard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contact> paginateGetting(int page, int row, Contact standard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
