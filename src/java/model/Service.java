/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.descriptionType;

/**
 *
 * @author Admin
 */
public class Service extends AbsModel{
    private int id;
    private String name;
    private ServiceType type;
    private String images;
    private double time;
    private int ordered;
    private String description;
    private double price;

    public Service() {
    }

    public Service(int id, String name, ServiceType type, String images, double time, int ordered, String description, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.images = images;
        this.time = time;
        this.ordered = ordered;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", name=" + name + ", type=" + type + ", images=" + images + ", time=" + time + ", ordered=" + ordered + ", description=" + description + ", price=" + price + '}';
    }

    
}