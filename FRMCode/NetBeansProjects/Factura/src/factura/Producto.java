
package factura;

public class Producto {
    String codigo;
    float precio;
    public Producto(String c,float p){
        codigo=c;
        precio=p;
    }
    public void setprecio(float precio){
        this.precio=precio;
    }
    public void setcodigo(String codigo){
        this.codigo=codigo;
        }
    public String getcodigo(){
        return codigo;
    }
    public float getprecio(){
        return precio;
    }
    @Override
    public String toString(){
        return("Codigo:"+codigo+". Precio:"+precio);

    }
}
