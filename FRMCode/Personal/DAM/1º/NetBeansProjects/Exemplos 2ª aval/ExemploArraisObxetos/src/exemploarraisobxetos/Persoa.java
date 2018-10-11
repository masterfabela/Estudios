
package exemploarraisobxetos;

/**
 *
 * @author femio23
 */
public class Persoa implements Comparable{
    String nome, dni;

    public Persoa() {
    }

    public Persoa(String nome, String dni) {
        this.nome = nome;
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return"nome=" + nome + ", dni=" + dni;
    }

    @Override
    public int compareTo(Object t) {
        Persoa p= (Persoa)t;
        if (dni.compareToIgnoreCase(p.getDni())>0)
            return 1;
        else if(dni.compareToIgnoreCase(p.getDni())==0)
            return 0;
        else 
            return-1;
        
    }
 
    
}
