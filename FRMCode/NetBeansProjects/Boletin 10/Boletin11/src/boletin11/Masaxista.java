package boletin11;

public class Masaxista extends Persoa{
    String titulacion;
    int anosExperiencia;
    public Masaxista(String n, String a, int i, int di,int ae, String ti){
    super(n,a,i,di);
    titulacion=ti;
    anosExperiencia=ae;
    }
    public void darMasaxes(){}
    
    @Override
    public String toString(){
    return "Datos da persoa indicada:\nNome:"+nome+"\nApelidos:"+apelido+"\nId:"+id+"\nIdade:"+idade+"\nTitulacion:"+titulacion+"\nAnos de experiencia:"+anosExperiencia;
    }
}