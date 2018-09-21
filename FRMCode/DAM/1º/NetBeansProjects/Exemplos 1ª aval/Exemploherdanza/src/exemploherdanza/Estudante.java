package exemploherdanza;

public class Estudante extends Persoa {
    private String codigo;
    private int notafinal;
    public Estudante (String n, String a, int i, String c, int nf){
    super(n,a,i);
    codigo=c;
    notafinal=nf;
    }
    public String getcod(){
      return codigo;  
    }
    public int getnf(){
    return notafinal;
    }
    public void amosar(){
        System.out.println("**Impresion**"+
                "\nNome: "+getn()+
                "\nApelido: "+geta()+
                "\nIdade: "+geti()+
                "\nCodigo: "+getcod()+
                "\nNota final: "+getnf());
    }
    
   }

