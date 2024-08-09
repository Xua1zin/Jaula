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
public class CadastroFormularioModel {
    private int form_id;
    private int imc_id;
    private String imc_name;
    private double form_height;
    private double form_weight;
    private double form_neck_width;
    private double form_waist_width;
    private String form_objective;
    private String form_feeding_pattern;
    private String form_habits;
    private String form_exercises;
    private String form_feces;
    private String form_urine;
    private String form_sintoms;
    private String form_observation;
    private Date form_exam_date;
    private int form_status_id;
    private String form_status_name;
    private String form_medication;
    private int patient_id;
    private String patient_name;
    private Date patient_birthdate;
    private int sex_id;
    private String sex_name;
    
    public CadastroFormularioModel(){
    }
    
    public CadastroFormularioModel(int imc_id, String imc_name, double form_height, double form_weight, double form_neck_width, 
    double form_waist_width, String form_objective, String form_feeding_pattern, String form_habits, 
    String form_exercises, String form_feces, String form_urine, String form_sintoms, String form_observation, 
    Date form_exam_date, int form_status_id, String form_status_name, String form_medication, int patient_id, 
    String patient_name, Date patient_birthdate, int sex_id, String sex_name){
        this.imc_id = imc_id;
        this.imc_name = imc_name;
        this.form_height = form_height;
        this.form_weight = form_weight;
        this.form_neck_width = form_neck_width;
        this.form_waist_width = form_waist_width;
        this.form_objective = form_objective;
        this.form_feeding_pattern = form_feeding_pattern;
        this.form_habits = form_habits;
        this.form_exercises = form_exercises;
        this.form_feces = form_feces;
        this.form_urine = form_urine;
        this.form_sintoms = form_sintoms;
        this.form_observation = form_observation;
        this.form_exam_date = form_exam_date;
        this.form_status_id = form_status_id;
        this.form_status_name = form_status_name;
        this.form_medication = form_medication;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
    }
    
    public CadastroFormularioModel(int form_id, int imc_id, String imc_name, double form_height, double form_weight, double form_neck_width, 
    double form_waist_width, String form_objective, String form_feeding_pattern, String form_habits, 
    String form_exercises, String form_feces, String form_urine, String form_sintoms, String form_observation, 
    Date form_exam_date, int form_status_id, String form_status_name, String form_medication, int patient_id, 
    String patient_name, Date patient_birthdate, int sex_id, String sex_name){
        this.imc_id = imc_id;
        this.imc_name = imc_name;
        this.form_height = form_height;
        this.form_weight = form_weight;
        this.form_neck_width = form_neck_width;
        this.form_waist_width = form_waist_width;
        this.form_objective = form_objective;
        this.form_feeding_pattern = form_feeding_pattern;
        this.form_habits = form_habits;
        this.form_exercises = form_exercises;
        this.form_feces = form_feces;
        this.form_urine = form_urine;
        this.form_sintoms = form_sintoms;
        this.form_observation = form_observation;
        this.form_exam_date = form_exam_date;
        this.form_status_id = form_status_id;
        this.form_status_name = form_status_name;
        this.form_medication = form_medication;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_birthdate = patient_birthdate;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
    }

    public int getFormID() {
        return form_id;
    }

    public void setFormID(int form_id) {
        this.form_id = form_id;
    }

    public int getImcID() {
        return imc_id;
    }

    public void setImcID(int imc_id) {
        this.imc_id = imc_id;
    }

    public String getImcName(){
        return imc_name;
    }
    
    public void setImcName(String imc_name){
        this.imc_name = imc_name;
    }
    
    public double getFormHeight() {
        return form_height;
    }

    public void setFormHeight(double form_height) {
        this.form_height = form_height;
    }

    public double getFormWeight() {
        return form_weight;
    }

    public void setFormWeight(double form_weight) {
        this.form_weight = form_weight;
    }

    public double getFormNeckWidth() {
        return form_neck_width;
    }

    public void setFormNeckWidth(double form_neck_width) {
        this.form_neck_width = form_neck_width;
    }

    public double getFormWaistWidth() {
        return form_waist_width;
    }

    public void setFormWaistWidth(double form_waist_width) {
        this.form_waist_width = form_waist_width;
    }

    public String getFormObjective() {
        return form_objective;
    }

    public void setFormObjective(String form_objective) {
        this.form_objective = form_objective;
    }

    public String getFormFeedingPattern() {
        return form_feeding_pattern;
    }

    public void setFormFeedingPattern(String form_feeding_pattern) {
        this.form_feeding_pattern = form_feeding_pattern;
    }

    public String getFormHabits() {
        return form_habits;
    }

    public void setFormHabits(String form_habits) {
        this.form_habits = form_habits;
    }

    public String getFormExercises() {
        return form_exercises;
    }

    public void setFormExercises(String form_exercises) {
        this.form_exercises = form_exercises;
    }

    public String getFormFeces() {
        return form_feces;
    }

    public void setFormFeces(String form_feces) {
        this.form_feces = form_feces;
    }

    public String getFormUrine() {
        return form_urine;
    }

    public void setFormUrine(String form_urine) {
        this.form_urine = form_urine;
    }

    public String getFormSintoms() {
        return form_sintoms;
    }

    public void setFormSintoms(String form_sintoms) {
        this.form_sintoms = form_sintoms;
    }

    public String getFormObservation() {
        return form_observation;
    }

    public void setFormObservation(String form_observation) {
        this.form_observation = form_observation;
    }

    public Date getFormExamDate() {
        return form_exam_date;
    }

    public void setFormExamDate(Date form_exam_date) {
        this.form_exam_date = form_exam_date;
    }

    public int getFormStatusID() {
        return form_status_id;
    }

    public void setFormStatusID(int form_status_id) {
        this.form_status_id = form_status_id;
    }

    public String getFormStatusName(){
        return form_status_name;
    }
    
    public void setFormStatusName(String form_status_name){
        this.form_status_name = form_status_name;
    }
    
    public String getFormMedication() {
        return form_medication;
    }

    public void setFormMedication(String form_medication) {
        this.form_medication = form_medication;
    }
    
    public int getPatientID(){
        return patient_id;
    }
    
    public void setPatientID(int patient_id){
        this.patient_id = patient_id;
    }
    
    public String getPatientName(){
        return patient_name;
    }
    
    public void setPatientName(String patient_name){
        this.patient_name = patient_name;
    }
    
    public Date getPatientBirthdate(){
        return patient_birthdate;
    }
    
    public void setPatientBirthdate(Date patient_birthdate){
        this.patient_birthdate = patient_birthdate;
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
