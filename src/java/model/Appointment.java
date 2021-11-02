/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Appointment extends AbsModel{
    private int id;
    private Employee employee;
    private Customer customer;
    private double fromHour, toHour;
    private Date date;
    private String description;
    private ArrayList<Service> services = new ArrayList<>();
            
    public Appointment() {
    }

    public Appointment(int id, Employee employee, Customer customer, double fromHour , double toHour , 
            Date date, String description, ArrayList<Service> services) {
        this.id = id;
        this.employee = employee;
        this.customer = customer;
        this.fromHour = fromHour ;
        this.toHour  = toHour ;
        this.date = date;
        this.description = description;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getFromHour() {
        return fromHour ;
    }

    public void setFromHour(double fromHour ) {
        this.fromHour  = fromHour ;
    }

    public double getToHour() {
        return toHour;
    }

    public void setToHour(double toHour) {
        this.toHour = toHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    
    
}
