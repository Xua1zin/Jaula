/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
public class Sexo {
    private int sex_id;
    private String sex_name;
    
    public Sexo(){
    }
    
    public Sexo(String sex_name){
        this.sex_name = sex_name;
    }
    
    public Sexo(int sex_id, String sex_name){
        this.sex_id = sex_id;
        this.sex_name = sex_name;
    }
    
    public int getSexID(){
        return sex_id;
    }
    
    public void setSexID(int sex_id){
        this.sex_id = sex_id;
    }
    
    public String getSexName(){
        return sex_name;
    }
    
    public void setSexName(String sex_name){
        this.sex_name = sex_name;
    }
}
