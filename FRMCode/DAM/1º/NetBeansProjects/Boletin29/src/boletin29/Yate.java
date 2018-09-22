/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin29;

/**
 *
 * @author femio23
 */
public class Yate extends Barco {
    int potencia,camarotes;

    public Yate(int potencia, int camarotes, int eslora, String matricula) {
        super(eslora, matricula);
        this.potencia = potencia;
        this.camarotes = camarotes;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(int camarotes) {
        this.camarotes = camarotes;
    }

    @Override
    public String toString() {
        return "Yate " +this.matricula+ "potencia=" + potencia + ", camarotes=" + camarotes +
                "eslora = "+this.eslora;
    }

    @Override
    public int aluger(Barco b, int dias) {
        return b.moduloBase()*dias*potencia*camarotes;
    }
    
}
