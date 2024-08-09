/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
public class Permissoes {
    private int permissions_id;
    private String permissions_type;
    
    public Permissoes(){
    }
    
    public Permissoes(String permissions_type){
        this.permissions_type = permissions_type;
    }
    
    public Permissoes(int permissions_id, String permissions_type){
        this.permissions_id = permissions_id;
        this.permissions_type = permissions_type;
    }
    
    public int getPermissionsID(){
        return permissions_id;
    }
    
    public void setPermissionsID(int permissions_id){
        this.permissions_id = permissions_id;
    }
    
    public String getPermissionsType(){
        return permissions_type;
    }
    
    public void setPermissionsType(String permissions_type){
        this.permissions_type = permissions_type;
    }
}
