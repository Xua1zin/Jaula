/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


public class CadastroUsuarioModel {
    public int admin;
    private int user_id;
    private String user_login;
    private String user_password;
    private String user_name;
    private Date user_birthdate;
    private String user_cpf;
    private String user_rg;
    private int sex_id;
    private String sex_name;
    private String crn;
    private int nationality_id;
    private String country_name;
    private String user_telefone;
    private String user_email;
    private String user_observation;
    private int permissions_id;
    private String permissions_type;
    private int user_status_id;
    private String user_status_name;
    private int region_id;
    private String region_name;
    
    public CadastroUsuarioModel(){
    }
    
    public CadastroUsuarioModel(int admin, String user_login, String user_password, String user_name, Date user_birthdate, 
            String user_cpf, String user_rg, int sex_id, String sex_name, String crn, int nationality_id, 
            String country_name, String user_telefone, String user_email, String user_observation, int permissions_id, 
            String permissions_type, int user_status_id, String user_status_name, int region_id, String region_name){
        this.admin = admin;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_birthdate = user_birthdate;
        this.user_cpf = user_cpf;
        this.user_rg = user_rg;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
        this.crn = crn;
        this.nationality_id = nationality_id;
        this.country_name = country_name;
        this.user_telefone = user_telefone;
        this.user_email = user_email;
        this.user_observation = user_observation;
        this.permissions_id = permissions_id;
        this.permissions_type = permissions_type;
        this.user_status_id = user_status_id;
        this.user_status_name = user_status_name;
        this.region_id = region_id;
        this.region_name = region_name;
    }
    
    public CadastroUsuarioModel(int admin, int user_id, String user_login, String user_password, String user_name, Date user_birthdate,
            String user_cpf, String user_rg, int sex_id, String sex_name, String crn, int nationality_id, 
            String country_name, String user_telefone, String user_email, String user_observation, int permissions_id, 
            String permissions_type, int user_status_id, String user_status_name, int region_id, String region_name){
        this.admin = admin;
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_birthdate = user_birthdate;
        this.user_cpf = user_cpf;
        this.user_rg = user_rg;
        this.sex_id = sex_id;
        this.sex_name = sex_name;
        this.crn = crn;
        this.nationality_id = nationality_id;
        this.country_name = country_name;
        this.user_telefone = user_telefone;
        this.user_email = user_email;
        this.user_observation = user_observation;
        this.permissions_id = permissions_id;
        this.permissions_type = permissions_type;
        this.user_status_id = user_status_id;
        this.user_status_name = user_status_name;
        this.region_id = region_id;
        this.region_name = region_name;
    }
    
    public int getAdmin(){
        return admin;
    }
    public void setAdmin(int admin){
        this.admin = admin;
    }
    
    public int getUserID(){
        return user_id;
    }
    
    public void setUserID(int user_id){
        this.user_id = user_id;
    }
    
    public String getUserLogin(){
        return user_login;
    }
    
    public void setUserLogin(String user_login){
        this.user_login = user_login;
    }
    
    public String getUserPassword(){
        return user_password;
    }
    
    public void setUserPassword(String user_password){
        this.user_password = user_password;
    }
    
    public String getUserName(){
        return user_name;
    }
    
    public void setUserName(String user_name){
        this.user_name = user_name;
    }
    
    public Date getUserBirthdate(){
        return user_birthdate;
    }
    
    public void setUserBirthdate(Date user_birthdate){
        this.user_birthdate = user_birthdate;
    }
    
    public String getUserCPF(){
        return user_cpf;
    }
    
    public void setUserCPF(String user_cpf){
        this.user_cpf = user_cpf;
    }
    
    public String getUserRG(){
        return user_rg;
    }
    
    public void setUserRG(String user_rg){
        this.user_rg = user_rg;
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
    
    public String getCRN(){
        return crn;
    }
    
    public void setCRN(String crn){
        this.crn = crn;
    }
    
    public int getNationalityID(){
        return nationality_id;
    }
    
    public void setNationalityID(int nationality_id){
        this.nationality_id = nationality_id;
    }
    
    public String getCountryName(){
        return country_name;
    }
    
    public void setCountryName(String country_name){
        this.country_name = country_name;
    }
    
    public String getUserTelefone(){
        return user_telefone;
    }
    
    public void setUserTelefone(String user_telefone){
        this.user_telefone = user_telefone;
    }
    
    public String getUserEmail(){
        return user_email;
    }
    
    public void setUserEmail(String user_email){
        this.user_email = user_email;
    }
    
    public String getUserObservation(){
        return user_observation;
    }
    
    public void setUserObservation(String user_observation){
        this.user_observation = user_observation;
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
    
    public int getUserStatusID(){
        return user_status_id;
    }
    
    public void setUserStatusID(int user_status_id){
        this.user_status_id = user_status_id;
    }
    
    public String getUserStatusName(){
        return user_status_name;
    }
    
    public void setUserStatusName(String user_status_name){
        this.user_status_name = user_status_name;
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
