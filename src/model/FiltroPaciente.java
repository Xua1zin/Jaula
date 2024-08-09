/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
import java.util.Date;

public class FiltroPaciente {
    private int patient_id;
    private String patient_name;
    private Date patient_birthdate;
    private String patient_cpf;

    public FiltroPaciente() {
    }

    public FiltroPaciente(String patient_name, Date patient_birthdate, String patient_cpf){
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.patient_cpf = patient_cpf;
    }
    public FiltroPaciente(int patient_id, String patient_name, Date patient_birthdate, String patient_cpf) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.patient_cpf = patient_cpf;
    }

    public int getPatientID() {
        return patient_id;
    }

    public void setPatientID(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatientName() {
        return patient_name;
    }

    public void setPatientName(String patient_name) {
        this.patient_name = patient_name;
    }

    public Date getPatientBirthdate() {
        return patient_birthdate;
    }

    public void setPatientBirthdate(Date patient_birthdate) {
        this.patient_birthdate = patient_birthdate;
    }
    
    public String getPatientCPF(){
        return patient_cpf;
    }
    
    public void setPatientCPF(String patient_cpf){
        this.patient_cpf = patient_cpf;
    }
}

