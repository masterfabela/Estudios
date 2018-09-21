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
public abstract class Empregado {
    String nome,apelidos,dni,direccion,telefono;
    int aAntiguidade;
    double salario;
    Supervisor supervisor;//Cambiei Empregado por Supervisor, porque senón entraría nun bucle no que sempre tería que crear 
                          //a un Empregado mais para supervisar a dito empregado.

    public Empregado(String nome, String apelidos, String dni, String direccion, String telefono, double salario, Supervisor sup) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salario = salario;
        this.supervisor=sup;
    }
    public void imprimir(){
        System.out.println("Datos do empregado:"+
                "\nNome:"+nome+"\nApelidos: "+apelidos+"\nDNI: "+dni+"\nDireccion: "+direccion+"\nTelefono: "+
                "\nSalario: "+salario+"\nAnos de antiguidade: "+aAntiguidade+"\nNome do supervisor: "+supervisor.nome);
    }
    public void cambiosupervisor(Supervisor sup){
        supervisor=sup;
    }
    public void incsalario(int plussalario){
    salario=salario+plussalario;
    }
    
}
