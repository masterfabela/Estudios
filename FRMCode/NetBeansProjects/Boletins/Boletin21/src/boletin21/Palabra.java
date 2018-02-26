package boletin21;

public class Palabra {
    private String pal;

    public Palabra(String pal) {
        this.pal = pal;
    }

    public Palabra() {
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    @Override
    public String toString() {
        return "pal=" + pal;
    }
    
    
}
