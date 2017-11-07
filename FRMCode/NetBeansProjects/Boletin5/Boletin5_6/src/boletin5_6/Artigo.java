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
    public void tipo(String n){
    if(n.getc()>1000){
        System.out.println("Este artigo é de primeira necesidade");
    }else{
    if(n.getc()>=500){
    System.out.println("Este artigo é de consumo alto");
    }else{
    if(n.getc()>=100){
    System.out.println("Este artigo é de consumo medio");
    }else{if(n.getc()<100){
    System.out.println("Este artigo é de consumo baixo");
    }
        
        }
    }
    }
    }
}
