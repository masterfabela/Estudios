/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obx;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Femio
 */
public class Coches implements Serializable{
    private String codigo;
    private String marca;
    private String modelo;
    private String cif;

    public Coches() {
    }

    public Coches(String codigo, String marca, String modelo, String cif) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.cif = cif;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    
}
