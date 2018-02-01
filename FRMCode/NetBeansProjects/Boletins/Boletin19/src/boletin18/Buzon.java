package boletin18;
import java.util.*;

public class Buzon {
    
    ArrayList <Correo> c=new ArrayList();
    public int numeroDeCorreos(){
        return c.size();
    }
    public void engade(Correo co){
        c.add(co);
    }
    public boolean porLer(){
        int sl=0;
        for(Correo cont:c){
            if(cont.lido==false){
            sl++;
            }
            
        }
        if (sl>0){
            return false;
        }else{
            return true;
        }
    }
    public String amosaPrimerNoLeido(){
    //d) String amosaPrimerNoLeido(), que amostra o primeiro correo non lido
    int mem=0;
    String m=null;
        for(Correo cont:c){
            if(cont.lido==false){
                 m=cont.contido;
                 break;
            }
    
    }
        return m;
    }
    public String amosa(int k){
    return c.get(k).contido;
    }
    public void elimina(int k){
    c.remove(k);
    }
    public void scramble(){
        int i=0;
    for(Correo cont:c){
        i++;
        System.out.println(i+"º Correo "+cont.contido+"  Lido? "+cont.lido);
    }
    }
}
