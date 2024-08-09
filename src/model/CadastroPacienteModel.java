/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Maria Beatriz
 */
public class CadastroPacienteModel {
    private int patient_id;
    private String patient_name;
    private Date patient_birthdate;
    private String patient_cpf;
    private String patient_rg;
    private String patient_telefone;
    private String patient_email;
    private String patient_cep;
    private String patient_observation;
    private String patient_pathological;
    private String patient_allergies;
    private String intolerance;
    private String patient_mental_history;
    private int sex_id;
    private String sex_name;
    private int nationality_id;
    private String country_name;
    private String patient_job;
    
    public CadastroPacienteModel(){
    }
    
    public CadastroPacienteModel(String patient_name, Date patient_birthdate, String patient_cpf, String patient_rg,
            String patient_telefone, String patient_email, String patient_cep, String patient_observation, 
            String patient_pathological, String patient_allergies, String intolerance, String patient_mental_history,
            int sex_id, String sex_name, int nationality_id, String country_name, String patient_job){
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.patient_cpf = patient_cpf;
        this.patient_rg = patient_rg;
        this.patient_telefone = patient_telefone;
        this.patient_email = patient_email;
        this.patient_cep = patient_cep;
        this.patient_observation = patient_observation;
        this.patient_pathological = patient_pathological;
        this.patient_allergies = patient_allergies;
        this.intolerance = intolerance;
        this.patient_mental_history = patient_mental_history;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
        this.nationality_id = nationality_id;
        this.country_name = country_name;
        this.patient_job = patient_job;
    }
    
    public CadastroPacienteModel(int patient_id, String patient_name, Date patient_birthdate, String patient_cpf, 
            String patient_rg, String patient_telefone, String patient_email, String patient_cep, 
            String patient_observation, String patient_pathological, String patient_allergies, String intolerance, 
            String patient_mental_history, int sex_id, String sex_name, int nationality_id, String country_name,
            String patient_job){
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.patient_cpf = patient_cpf;
        this.patient_rg = patient_rg;
        this.patient_telefone = patient_telefone;
        this.patient_email = patient_email;
        this.patient_cep = patient_cep;
        this.patient_observation = patient_observation;
        this.patient_pathological = patient_pathological;
        this.patient_allergies = patient_allergies;
        this.intolerance = intolerance;
        this.patient_mental_history = patient_mental_history;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
        this.nationality_id = nationality_id;
        this.country_name = country_name;
        this.patient_job = patient_job;
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

    public String getPatientCPF() {
        return patient_cpf;
    }

    public void setPatientCPF(String patient_cpf) {
        this.patient_cpf = patient_cpf;
    }

    public String getPatientRG() {
        return patient_rg;
    }

    public void setPatientRG(String patient_rg) {
        this.patient_rg = patient_rg;
    }

    public String getPatientTelefone() {
        return patient_telefone;
    }

    public void setPatientTelefone(String patient_telefone) {
        this.patient_telefone = patient_telefone;
    }

    public String getPatientEmail() {
        return patient_email;
    }
    
    public void setPatientEmail(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatientCEP() {
        return patient_cep;
    }

    public void setPatientCEP(String patient_cep) {
        this.patient_cep = patient_cep;
    }
    
    public String getPatientObservation() {
        return patient_observation;
    }

    public void setPatientObservation(String patient_observation) {
        this.patient_observation = patient_observation;
    }

    public String getPatientPathological() {
        return patient_pathological;
    }

    public void setPatientPathological(String patient_pathological) {
        this.patient_pathological = patient_pathological;
    }

    public String getPatientAllergies() {
        return patient_allergies;
    }

    public void setPatientAllergies(String patient_allergies) {
        this.patient_allergies = patient_allergies;
    }

    public String getIntolerance() {
        return intolerance;
    }

    public void setIntolerance(String intolerance) {
        this.intolerance = intolerance;
    }

    public String getPatientMentalHistory() {
        return patient_mental_history;
    }

    public void setPatientMentalHistory(String patient_mental_history) {
        this.patient_mental_history = patient_mental_history;
    }

    public int getSexID() {
        return sex_id;
    }

    public void setSexID(int sex_id) {
        this.sex_id = sex_id;
    }
    
    public String getSexName(){
        return sex_name;
    }

    public void setSexName(String sex_name){
        this.sex_name = sex_name;
    }
    
    public int getNationalityID() {
        return nationality_id;
    }

    public void setNationalityID(int nationality_id) {
        this.nationality_id = nationality_id;
    }
    
    public String getCountryName(){
        return country_name;
    }
    
    public void setCountryName(String country_name){
        this.country_name = country_name;
    }

    public String getPatientJob() {
        return patient_job;
    }

    public void setPatientJob(String patient_job) {
        this.patient_job = patient_job;
    }
}
