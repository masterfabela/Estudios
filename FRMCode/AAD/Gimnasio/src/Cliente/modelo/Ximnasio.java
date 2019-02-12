/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.modelo;
import java.util.ArrayList;

/**
 *
 * @author a18franciscorm
 */
public class Ximnasio {
    
    private String cif,nome;
    private ArrayList<Actividade>actividades;
    private ArrayList<Cliente> clientes;

    public Ximnasio() {
    }
    
    public Ximnasio(String cif, String nome, ArrayList<Actividade> actividades, ArrayList<Cliente> clientes) {
        this.cif = cif;
        this.nome = nome;
        this.actividades = actividades;
        this.clientes = clientes;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Actividade> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividade> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
