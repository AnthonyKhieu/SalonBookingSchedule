/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AppointmentDetail extends AbsModel{
    private Appointment appointment;
    private ArrayList<ServiceType> services = new ArrayList();

    public AppointmentDetail() {
    }
    
    public AppointmentDetail(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public ArrayList<ServiceType> getServices() {
        return services;
    }

    public void setServices(ArrayList<ServiceType> services) {
        this.services = services;
    }
    
    
    
    
}
