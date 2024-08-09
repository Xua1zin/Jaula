/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
public class Regiao {
    private int region_id;
    private String region_name;
    
    public Regiao(){
    }
    
    public Regiao(String region_name){
        this.region_name = region_name;
    }
    
    public Regiao(int region_id, String region_name){
        this.region_id = region_id;
        this.region_name = region_name;
    }
    
    public int getRegionID(){
        return region_id;
    }
    
    public void setRegionID(int region_id){
        this.region_id = region_id;
    }
    
    public String getRegionName(){
        return region_name;
    }
    
    public void setRegionName(String region_name){
        this.region_name = region_name;
    }
}
