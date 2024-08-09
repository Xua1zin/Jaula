/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
public class Nacionalidade {
    private int nationality_id;
    private String country_name;
    
    public Nacionalidade(){
    }
    
    public Nacionalidade(String country_name){
        this.country_name = country_name;
    }
    
    public Nacionalidade(int nationality_id, String country_name){
        this.nationality_id = nationality_id;
        this.country_name = country_name;
    }
    
    public int getNationalityID(){
        return nationality_id;
    }
    
    public String getCountryName(){
        return country_name;
    }
    
    public void setNationalityID(int nationality_id){
        this.nationality_id = nationality_id;
    }
    
    public void setCountryName(String country_name){
        this.country_name = country_name;
    }
}
