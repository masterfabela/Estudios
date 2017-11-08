package boletin5_6;
public class Artigo {
    String nome;
    int cantidade;
    public Artigo(String n, int c){
        nome=n;
        cantidade=c;
    }
    public String getn(){
    return nome;
    }
    public int getc(){
    return cantidade;
    }
    public void tipo(Artigo n){
    if(cantidade>1000){
        //para consultar o atrivuto de calquera obxeto, usar unha variable "consulta", e asignolle un get
        //ou tamen podo recivir un obxeto da clase, e despois operar cos atributos.
    System.out.println("Este artigo é de primeira necesidade");
    }else{
    if(cantidade>=500){
    System.out.println("Este artigo é de consumo alto");
    }else{
    if(cantidade>=100){
    System.out.println("Este artigo é de consumo medio");
    }else{if(cantidade<100){
    System.out.println("Este artigo é de consumo baixo");
    }
        
        }
    }
    }
    }
}
