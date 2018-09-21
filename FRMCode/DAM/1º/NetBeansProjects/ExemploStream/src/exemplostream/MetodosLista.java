/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplostream;

import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class MetodosLista {
    ArrayList<MetodosLista> listalumnos=new ArrayList();
    String nome,id,ciclo;
    float nota;

    public ArrayList<MetodosLista> getListalumnos() {
        return listalumnos;
    }

    public void setListalumnos(ArrayList<MetodosLista> listalumnos) {
        this.listalumnos = listalumnos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    public MetodosLista(){}
    public MetodosLista(String n, String i, String c, float no){
        nome=n;
        id=i;
        nota=no;
        ciclo=c;
    }
    public void inicializar(){
    listalumnos.add(new MetodosLista("Pepe","222","DAM1",3));
    listalumnos.add(new MetodosLista("Jose","333","ASIR",6));
    }
    
    public void ordear2(){
        listalumnos.stream().sorted((al1,al2)->al1.getNome().compareToIgnoreCase(al2.getNome()));
    }
    public void amosar(){
        listalumnos.stream().forEach((a1->System.out.println(a1)));
    }
}
