package factura;

public class Factura {

    public static void main(String[] args) {
    Producto p1=new Producto("C1",24);
    Producto p2=new Producto("H23",234);
    Producto p3=new Producto("M30",109);
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    System.out.println(p3.toString());   
    p2.setcodigo("K123");
    p2.setprecio(247);
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    System.out.println(p3.toString());   
    }
    
}
