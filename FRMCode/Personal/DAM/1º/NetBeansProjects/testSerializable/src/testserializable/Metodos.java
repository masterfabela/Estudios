/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Femio
 */
public class Metodos{
    
    public void gardar() throws FileNotFoundException, IOException{
        ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream("media.obj"));
        Conexo c1=new Conexo();
        o1.writeObject(c1);
        
    }
    public Conexo leer() throws FileNotFoundException, IOException, ClassNotFoundException{
    ObjectInputStream o2 = new ObjectInputStream(new FileInputStream("media.obj"));
    return (Conexo) o2.readObject();
    }
    
}
