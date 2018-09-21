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
public class DeporMotor extends Barco{
    int potencia;

    public DeporMotor(int potencia, int eslora, String matricula) {
        super(eslora, matricula);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "DeporMotor " +this.matricula+ ": Potencia=" + potencia + "eslora = "+this.eslora;
    }

    @Override
    public int aluger(Barco b, int dias) {
        return b.moduloBase()*dias*potencia;
    }
    
}
