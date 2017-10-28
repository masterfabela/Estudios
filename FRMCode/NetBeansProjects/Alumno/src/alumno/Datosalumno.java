package alumno;
import java.util.Scanner;
public class Datosalumno {
    Scanner sc=new Scanner(System.in);
    String nome;
    
    public void setnome(String n){
    nome=n;
    }
    public String getnome(){
        return nome;
    }
    public Datosalumno(){
}
    public Datosalumno(String n, String r, int no, String t, String d ){
         nome=n;
         Datosacademicos x = new Datosacademicos(r,no);
         Datospersoais y = new Datospersoais(d,t);
         System.out.println("Os datos do alumno son so seguintes.\nNome:"+
        nome+"\nReferencia:"+x.getreferencia()+"\nNota:"+x.getnota()+
                "\nDireccion:"+y.getdireccion()+"\nTelefono:"+y.gettlfn());
    }
    /*@Override
    public String toString(){
        return ("Os datos do alumno son so seguintes.\nNome:"+
        nome+"\nReferencia:"+academicos.getreferencia()+"\nNota:"+academicos.getnota()+"\nDireccion:"+
        persoais.getdireccion()+"\nTelefono:"+persoais.gettlfn());
    }*/
}
