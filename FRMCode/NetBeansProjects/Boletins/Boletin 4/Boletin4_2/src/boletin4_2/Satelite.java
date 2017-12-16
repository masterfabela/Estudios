package boletin4_2;

public class Satelite {
   
 
     private double meridiano ;
     private double paralelo;
     private double distanciaTerra ;

 public Satelite ( ) {

  meridiano = paralelo = distanciaTerra = 0 ;
}

public Satelite ( double m, double p , double d ){

meridiano = m ;
paralelo = p;
distanciaTerra = d ;

}
public void verPosicion ( ) {

System.out.println ("O satelite atopase  no paralelo " +paralelo + " meridiano " + meridiano +" a unha distancia da terra " + distanciaTerra+" ." ) ;    

}
}
