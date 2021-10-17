/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ServiceType extends AbsModel{
    private int typeID;
    private String typeName;
    private boolean isMain;

    public ServiceType() {
    }

    public ServiceType(int typeID, String typeName, boolean isMain) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.isMain = isMain;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isIsMain() {
        return isMain;
    }

    public void setIsMain(boolean isMain) {
        this.isMain = isMain;
    }
    
    
    
    
}
