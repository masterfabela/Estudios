package boletin16;
import com.fran.personal.Personal;
public class Academia {
    private int numref;
    private String nome;
    private float nota;
    Personal alumno;
    static int nref=2018;

    public Academia() {
    }
    
    

    public Academia(int numref, String nome, float nota, Personal alumno) {
        this.numref = numref;
        this.nome = nome;
        this.nota = nota;
        this.alumno = alumno;
        nref++;
        
    }

    public int getNumref() {
        return numref;
    }

    public void setNumref(int numref) {
        this.numref = numref;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Personal getAlumno() {
        return alumno;
    }

    public void setAlumno(Personal alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Academia{" + "numref=" + numref + ", nome=" + nome + ", nota=" + nota + ", alumno=" + alumno.toString() + '}';
    }
    
    
}
