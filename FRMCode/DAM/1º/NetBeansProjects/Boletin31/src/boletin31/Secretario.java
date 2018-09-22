/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin31;

/**
 *
 * @author femio23
 */
public class Secretario extends Empregado{
    String despacho,fax;

    public Secretario(String nome, String apelidos, String dni, String direccion, String telefono, double salario, Supervisor sup,String fax,String despacho) {
        super(nome, apelidos, dni, direccion, telefono, salario, sup);
        this.fax=fax;
        this.despacho=despacho;
        aAntiguidade=2;
        
    }
    @Override
    public void incsalario(int plussalario){
        salario=salario+salario*(0.05*aAntiguidade);
    }
    @Override
    public void imprimir(){
        System.out.println("Datos do empregado,(Secretario):"+
                "\nNome:"+nome+"\nApelidos: "+apelidos+"\nDNI: "+dni+"\nDireccion: "+direccion+"\nTelefono: "+
                "\nSalario: "+salario+"\nAnos de antiguidade: "+aAntiguidade+"\nNome do supervisor: "+supervisor.nome+
                "\nFax: "+fax+"\nDespacho: "+despacho);
    }
}
