package datos_academicos;

public class NotasAlumno {
    private String nome;
    float nota;

    public NotasAlumno() {
        nome="aaa";
        nota=2;
    }

    public NotasAlumno(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNotas() {
        return nota;
    }

    public void setNotas(float notas) {
        this.nota = notas;
    }

    @Override
    public String toString() {
        return "NotasAlumno{" + "nome=" + nome + ", notas=" + nota + '}';
    }
    
}
