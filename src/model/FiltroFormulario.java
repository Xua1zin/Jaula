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
public class FiltroFormulario {
    private Integer formID;
    private Integer pacientID;
    private String nome;
    private Date dataNascimento;
    private String status;

    public FiltroFormulario(){
    }
    
    public FiltroFormulario (Integer pacientID, String nome, Date dataNascimento, String status){
        this.pacientID = pacientID;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = status;
    }
    
    public FiltroFormulario(Integer formID, Integer pacientID, String nome, Date dataNascimento, String status) {
        this.formID = formID;
        this.pacientID = pacientID;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = status;
    }

    public Integer getFormID() {
        return formID;
    }

    public void setFormID(Integer formID) {
        this.formID = formID;
    }

    public Integer getPacientID() {
        return pacientID;
    }

    public void setPacientID(Integer pacientID) {
        this.pacientID = pacientID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
