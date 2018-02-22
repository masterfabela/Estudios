
package boletin20;

public class Libro {
    private String autor, titulo;
    private float prezo;
    private int unidades;

    public Libro() {
    }
    public Libro(String titulo, String autor, float prezo, int unidades) {
        this.autor = autor;
        this.titulo = titulo;
        this.prezo = prezo;
        this.unidades = unidades;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrezo() {
        return prezo;
    }

    public int getUnidades() {
        return unidades;
    }

    @Override
    public String toString() {
        return "Autor= " + autor + " Titulo= " + titulo + " Prezo= " + prezo + " Unidades= " + unidades;
    }
    
}
