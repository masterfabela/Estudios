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
public class Velerio extends Barco {
    int mastiles;

    public Velerio(int mastiles, int eslora, String matricula) {
        super(eslora, matricula);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }

    @Override
    public String toString() {
        return "Velerio "+this.matricula + "mastiles=" + mastiles + "eslora = "+this.eslora;
    }

    @Override
    public int aluger(Barco b, int dias) {
        return b.moduloBase()*dias*mastiles;
    }

}
