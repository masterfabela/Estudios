/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin28;

/**
 *
 * @author femio23
 */
public class Alumno {
    private String nome;
    private int nota;
    private Enderezo enderezo;
    Enderezo e1;
    public Alumno(){
    nome="Juan";
    nota=5;
    e1=new Enderezo("Albarello",24);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nome=" + nome + ", nota=" + nota +'}';
    }
    public void cambiarnota(int n){
        this.nota=n;
    }
    public void amosar(){
        
        System.out.println(toString()+e1.toString());
    }
    
    private class Enderezo{
        private String rua;
        private int numero;
        public Enderezo(String nome, int n){
        rua=nome;
        numero=n;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        @Override
        public String toString() {
            return "Enderezo{" + "rua=" + rua + ", numero=" + numero + '}';
        }
        
    }
}
