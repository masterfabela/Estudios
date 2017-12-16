package boletin11;

public class Masaxista extends Persoa{
    private String titulacion;
    private int anosExperiencia;
    public Masaxista(String n, String a, int i, int di,int ae, String ti){
    super(n,a,i,di);
    titulacion=ti;
    anosExperiencia=ae;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
    
    public void darMasaxes(){}
    
    public String toString(Masaxista m){
    return "Datos da persoa indicada:\nNome:"+m.getNome()+"\nApelidos:"+m.getApelido()+"\nId:"+getId()+"\nIdade:"+getIdade()+"\nTitulacion:"+m.getTitulacion()+"\nAnos de experiencia:"+m.getAnosExperiencia();
    }
}