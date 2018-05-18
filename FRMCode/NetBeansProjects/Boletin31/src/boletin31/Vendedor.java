/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin31;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Vendedor extends Empregado{
    String telefonomovil,areaventa;
    Coche cochempresa;
    ArrayList listaclientes=new ArrayList();
    double comision;
    public Vendedor(String nome, String apelidos, String dni, String direccion, String telefono, double salario, Supervisor sup,Coche c,String telmovil,String aventa,ArrayList lclientes,double comision) {
        super(nome, apelidos, dni, direccion, telefono, salario, sup);
        this.cochempresa=c;
        this.telefonomovil=telmovil;
        this.areaventa=aventa;
        this.listaclientes=lclientes;
        this.comision=comision;
        aAntiguidade=2;
     
    }
    @Override
    public void incsalario(int plussalario){
        salario=salario+salario*(aAntiguidade*0.1);
    }
    @Override
    public void imprimir(){
        System.out.println("Datos do empregado,(Vendedor):"+
                "\nNome:"+nome+"\nApelidos: "+apelidos+"\nDNI: "+dni+"\nDireccion: "+direccion+"\nTelefono: "+
                "\nSalario: "+salario+"\nAnos de antiguidade: "+aAntiguidade+"\nNome do supervisor: "+supervisor.nome+
                "\nCoche de empresa: "+cochempresa.matricula+
                "\nTelefono movil: "+telefonomovil+"\nArea de venta: "+areaventa+"\nComision: "+comision);
    }
    public void altaCliente(Cliente c){
    listaclientes.add(c);
    }
    public void baixaCliente(Cliente c){
    listaclientes.remove(c);
    }
    public void cambioCoche(Coche c){
    cochempresa=c;
    }
    
    
}
