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
public class Usuario extends Cliente{

    @Override
    public void importeUsos() {
        
    }

    public Usuario() {
    }

    public Usuario(String codigo, String nome, ArrayList<Uso> usos) {
        super(codigo, nome, usos);
    }
    
}
