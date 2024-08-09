/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class FormStatus {
    private int form_status_id;
    private String form_status_name;
    
    public FormStatus(){
    }
    
    public FormStatus(String form_status_name){
        this.form_status_name = form_status_name;
    }
    
    public FormStatus(int form_status_id, String form_status_name){
        this.form_status_id = form_status_id;
        this.form_status_name = form_status_name;
    }
    
    public int getFormStatusID(){
        return form_status_id;
    }
    
    public void setFormStatusID(int form_status_id){
        this.form_status_id = form_status_id;
    }
    
    public String getFormStatusName(){
        return form_status_name;
    }
    
    public void setFormStatusName(String form_status_name){
        this.form_status_name = form_status_name;
    }
}
