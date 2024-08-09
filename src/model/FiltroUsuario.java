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
public class FiltroUsuario {
    private Integer user_id;
    private String crn;
    private String user_name;
    private Date user_birthdate;
    private String user_status_name;

    public FiltroUsuario() {
    }

    public FiltroUsuario(Integer user_id, String crn, String user_name, Date user_birthdate, String user_status_name) {
        this.user_id = user_id;
        this.crn = crn;
        this.user_name = user_name;
        this.user_birthdate = user_birthdate;
        this.user_status_name = user_status_name;
    }

    public Integer getUserID() {
        return user_id;
    }

    public void setUserID(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCRN() {
        return crn;
    }

    public void setCRN(String crn) {
        this.crn = crn;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public Date getUserBirthdate() {
        return user_birthdate;
    }

    public void setUserBirthdate(Date user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String getUserStatusName() {
        return user_status_name;
    }

    public void setUserStatusName(String user_status_name) {
        this.user_status_name = user_status_name;
    }
}
