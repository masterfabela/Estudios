package programacomercio;

import javax.swing.JOptionPane;

public class Metodos {
    public String buscarnv(Ventas v,int d){
        String mem="Non hay nada.";
        int m1;
        for(int i=0;i<2;i++){
            m1=Integer.parseInt(v.nv[i]);
            if(d==m1){
                mem=v.nv[i];
                System.out.println(v.cant[i]);
            }
        
        }
    return mem;
    }
    public String vernv(Ventas v,String d){
    String mem="Non hay nada.";
    return mem;
    }
    public String entrada(String v){
    String s=JOptionPane.showInputDialog(v);
        return s;
    }
}
