/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1psp;

/**
 *
 * @author a18franciscorm
 */
public class Linea {
    String iniciais,cadea;
    int lonxitude,cantidade=1;

    public Linea(String iniciais, String cadea, int lonxitude) {
        this.iniciais = iniciais;
        this.cadea = cadea;
        this.lonxitude = lonxitude;
        this.cantidade = cantidade;
    }

    public String getIniciais() {
        return iniciais;
    }

    public void setIniciais(String iniciais) {
        this.iniciais = iniciais;
    }

    public String getCadea() {
        return cadea;
    }

    public void setCadea(String cadea) {
        this.cadea = cadea;
    }

    public int getLonxitude() {
        return lonxitude;
    }

    public void setLonxitude(int lonxitude) {
        this.lonxitude = lonxitude;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }
    
    public String devolvedor(){
        return iniciais+" "+lonxitude+" "+cadea+" "+cantidade;
    }
    
    @Override
    public String toString() {
        return "Linea{" + "iniciais=" + iniciais + ", cadea=" + cadea + ", lonxitude=" + lonxitude + ", cantidade=" + cantidade + '}';
    }
    
    
}
