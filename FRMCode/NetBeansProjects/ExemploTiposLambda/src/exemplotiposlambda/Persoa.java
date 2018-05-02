/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplotiposlambda;

import java.util.function.Supplier;

/**
 *
 * @author femio23
 */
public class Persoa {
    private String nome;
    private String apelido;
    private String direccion;
    
    public Persoa() {
    }

    public Persoa(String nome, String apelido, String direccion) {
        this.nome = nome;
        this.apelido = apelido;
        this.direccion = direccion;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persoa{" + "nome=" + nome + ", apelido=" + apelido + ", direccion=" + direccion + '}';
    }
    Supplier <Persoa> per;

    public void crear(){
        per=()->{
            return(new Persoa("Pepita","Perez","Urzaiz"));
        };
        System.out.println(per.get());
    }
    public void ver(){
        System.out.println(per.get());
    }
}
