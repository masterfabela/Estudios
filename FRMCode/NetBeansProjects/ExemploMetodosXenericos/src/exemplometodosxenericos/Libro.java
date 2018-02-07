package exemplometodosxenericos;
//import boletin.pkg19t.Boletin19t;
public class Libro {
    String titulo, isbn, autor;
    float prezo;
    int unidades;
    
    public Libro(String t,String i,String a,float p,int u){
        this.titulo=t;
        this.isbn=i;
        this.autor=a;
        this.prezo=p;
        this.unidades=u;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor + ", prezo=" + prezo + ", unidades=" + unidades + '}';
    }
    
}
