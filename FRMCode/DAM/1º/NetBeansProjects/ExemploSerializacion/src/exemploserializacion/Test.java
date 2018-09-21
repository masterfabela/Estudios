/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploserializacion;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author femio23
 */
public class Test implements Serializable {
    ArrayList obxetos=new ArrayList();
    public void engadir(String n){
        obxetos.add(n);
    }
    public ArrayList getObxetos(){
        return obxetos;
    }
    
}
