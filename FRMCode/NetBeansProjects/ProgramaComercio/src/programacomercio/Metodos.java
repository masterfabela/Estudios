package programacomercio;

public class Metodos {
    public String buscarnv(Ventas v,String d){
        String mem="Non hay nada.", m1;
        for(int i=0;i<v.nv.length;i++){
            m1=v.nv[i];
            if(d.compareToIgnoreCase(m1)){
                mem=v.nv[i];
                System.out.println(v.cant[i]);
            }
        
        }
    return mem;
    }
}
