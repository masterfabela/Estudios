package exemplometodosxenericos;

public class Correo {
    String contido;
    boolean lido;
    public Correo(String contido, boolean lido) {
        this.contido = contido;
        this.lido = lido;
    }

    @Override
    public String toString() {
        return "Correo{" + "contido=" + contido + ", lido=" + lido + '}';
    }
    
    
    
}
