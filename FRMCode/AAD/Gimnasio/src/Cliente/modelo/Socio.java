/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.modelo;
import java.util.ArrayList;

/**
 *
 * @author a18franciscorm
 */
public class Socio extends Cliente{
    private final int importeMensual=30;
    @Override
    public void importeUsos() {
        float total=0;
//        ArrayList<Uso> usos=super.getUsos();
//        for(Uso x:usos){
//            x.getNome()
//        }
    }

    public Socio() {
    }

    public Socio(String codigo, String nome, ArrayList<Uso> usos) {
        super(codigo, nome, usos);
    }
    
    
}
