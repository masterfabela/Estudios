/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fran.personal;

/**
 *
 * @author femio23
 */
public class Personal {
    private String correo;
    private String telefono;
    
    
    public Personal(){}

    public Personal(String correo, String telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Personal{" + "correo=" + correo + ", telefono=" + telefono + '}';
    }
}
