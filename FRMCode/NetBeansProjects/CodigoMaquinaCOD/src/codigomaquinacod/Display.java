/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomaquinacod;

/**
 *
 * @author femio23
 */
public class Display {
    public void mostrarcredito(Dinero d){
        System.out.println("Actualmente tiene un crédito de "+d.getCrédito()+" €.");
    }
    public void mostraraz(Cafetera c){
        System.out.println("Cantidad seleccionada de azucar: "+c.getCantazucar());
    }
    public float mostrarprecio(Productos[] prod,String e){
        float aux=0;
        for(Productos p1:prod){
            if(p1.getProducto().equalsIgnoreCase(e)){
                System.out.println("Precio: "+p1.getPrecio()+" €");
                aux= p1.getPrecio();
            }
        }
        return aux;
        }
    public void mostrarcambio(Dinero c){
        System.out.println("El cambio a devolver es de "+c.getCambio()+" €.");
    }
}
