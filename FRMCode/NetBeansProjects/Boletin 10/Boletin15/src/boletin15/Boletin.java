package boletin15;

public class Boletin {
    private int bentregar,bent,nota;

    public Boletin() {
    }

    public int getBentregar() {
        return bentregar;
    }

    public void setBentregar(int bentregar) {
        this.bentregar = bentregar;
    }

    public int getBent() {
        return bent;
    }

    public void setBent(int bent) {
        this.bent = bent;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
   
    public int cboletin(int ba,int bp){
        bent=ba;
        bentregar=bp;
        if(bent<(0.7*bentregar)){
        nota=0;
        }else{
            if(bent>=(0.7*bentregar)&&bent<=(0.9*bentregar)){
            nota=1;
            }else{
            nota=2;
            }
        }
        return nota;
    }
}
