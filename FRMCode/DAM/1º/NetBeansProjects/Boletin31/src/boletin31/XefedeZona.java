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
public class XefedeZona extends Empregado{
    String despacho;
    Empregado secretario;
    ArrayList<Vendedor>listavendedores=new ArrayList();
    Coche cochempresa;
    public XefedeZona(String nome, String apelidos, String dni, String direccion, String telefono, double salario, Supervisor sup,String despacho,Empregado secretario, ArrayList lvendedores,Coche cempresa) {
        super(nome, apelidos, dni, direccion, telefono, salario, sup);
        this.despacho=despacho;
        this.secretario=secretario;
        this.listavendedores=lvendedores;
        this.cochempresa=cempresa;
        aAntiguidade=2;
    }
    @Override
    public void incsalario(int plussalario){
    salario=salario+salario*(aAntiguidade*0.2);
    }
    @Override
    public void imprimir(){
        System.out.println("Datos do empregado,(Xefe de zona):"+
                "\nNome:"+nome+"\nApelidos: "+apelidos+"\nDNI: "+dni+"\nDireccion: "+direccion+"\nTelefono: "+
                "\nSalario: "+salario+"\nAnos de antiguidade: "+aAntiguidade+"\nNome do supervisor: "+supervisor.nome+
                "\nCoche de empresa: "+cochempresa.matricula+
                "\nCoche de empresa: "+cochempresa.matricula+"\nDespacho: "+despacho+"\nSecretario: "+secretario.nome);
    }
    public void cambioSecretario(Secretario sec){
        secretario=sec;
    }
    public void cambioCoche(Coche c){
        cochempresa=c;
    }
    public void altaVendedor(Vendedor v){
        listavendedores.add(v);
    }
    public void baixaVendedor(Vendedor v){
    listavendedores.remove(v);
    }
    
}
