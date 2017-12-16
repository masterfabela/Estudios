
package boletin14;

public class Coches {
    String matricula;
    float prezo;
    int tempo;

    public Coches() {}

    public Coches(String matricula, int tempo) {
        this.matricula = matricula;
        this.tempo = tempo;
    }
    public void preciar(){
        if(tempo<=3){
        prezo=1.5f;
        }else{
        prezo=(float)(1.5+0.2*tempo);
        }
    }
}
