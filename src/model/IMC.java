/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Maria Beatriz
 */
public class IMC {
    private int imc_id;
    private String imc_name;
    private double imc_minimum;
    private double imc_maximum;
    
    public IMC(){
    }
    
    public IMC(String imc_name, double imc_minimum, double imc_maximum){
        this.imc_name = imc_name;
        this.imc_minimum = imc_minimum;
        this.imc_maximum = imc_maximum;
    }
    
    public IMC(int imc_id, String imc_name, double imc_minimum, double imc_maximum){
        this.imc_id = imc_id;
        this.imc_name = imc_name;
        this.imc_minimum = imc_minimum;
        this.imc_maximum = imc_maximum;
    }

    public int getImcID() {
        return imc_id;
    }

    public void setImcID(int imc_id) {
        this.imc_id = imc_id;
    }

    public String getImcName() {
        return imc_name;
    }

    public void setImcName(String imc_name) {
        this.imc_name = imc_name;
    }

    public double getImcMinimum() {
        return imc_minimum;
    }

    public void setImcMinimum(double imc_minimum) {
        this.imc_minimum = imc_minimum;
    }

    public double getImcMaximum() {
        return imc_maximum;
    }

    public void setImcMaximum(double imc_maximum) {
        this.imc_maximum = imc_maximum;
    }    
}
