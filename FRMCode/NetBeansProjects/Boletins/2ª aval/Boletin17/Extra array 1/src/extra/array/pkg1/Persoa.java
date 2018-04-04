package extra.array.pkg1;

public class Persoa {
    float altura;
    String nome;

    public Persoa() {
    }

    public Persoa(float altura, String nome) {
        this.altura = altura;
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome +" ten unha altura de " + altura + " metros.";
    }
    
}
