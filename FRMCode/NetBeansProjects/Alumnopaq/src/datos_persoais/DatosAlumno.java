package datos_persoais;

import java.util.logging.Logger;

public class DatosAlumno {
    String nome;
    public String tlfn;

    public DatosAlumno() {
    }

    public DatosAlumno(String nome, String tlfn) {
        this.nome = nome;
        this.tlfn = tlfn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    @Override
    public String toString() {
        return "DatosAlumno{" + "nome=" + nome + ", tlfn=" + tlfn + '}';
    }
    
    
}
