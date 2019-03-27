/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author femio23
 */
public class Empregado implements Serializable{
    private String nome,oficio,dni,nDep;
    private int salario,comision;
    private Date dataAlta;
    private Vehiculo vehiculo;
    private Departamento departamento;

    public Empregado() {
    }

    public Empregado(String nome, String oficio, String dni, String nDep, int salario, int comision, Date dataAlta, Vehiculo vehiculo, Departamento departamento) {
        this.nome = nome;
        this.oficio = oficio;
        this.dni = dni;
        this.nDep = nDep;
        this.salario = salario;
        this.comision = comision;
        this.dataAlta = dataAlta;
        this.vehiculo = vehiculo;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getnDep() {
        return nDep;
    }

    public void setnDep(String nDep) {
        this.nDep = nDep;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
