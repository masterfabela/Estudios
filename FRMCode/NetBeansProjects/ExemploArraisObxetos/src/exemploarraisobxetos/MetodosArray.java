package exemploarraisobxetos;

import javax.swing.JOptionPane;

public class MetodosArray {
    public void amosar(Persoa[]lp){
        //bucle for forage
    for(Persoa ele:lp)
            System.out.println(ele);
    }
    public Persoa[]creararray(){
        int elem;
        elem=4;
                //Integer.parseInt(JOptionPane.showInputDialog("De cantos elementos constará o array?"));
        Persoa[]persoas=new Persoa[elem];
        persoas[0]=new Persoa("F","5");
        persoas[1]=new Persoa("D","2");
        persoas[2]=new Persoa("E","4");
        persoas[3]=new Persoa("G","3");
        
        /*String nome,dni;
        for(int i=0;i<persoas.length;i++){
            nome=JOptionPane.showInputDialog("Nome?");
            dni=JOptionPane.showInputDialog("DNI?");
        persoas[i]=new Persoa(nome,dni);
        }*/
        return persoas;
    }
    public Persoa buscar(Persoa[]lip, String dNi){
        int i=0;
        Persoa p1=new Persoa();
        for(Persoa dni:lip){ 
        if(lip[i].dni.equalsIgnoreCase(dNi)){
        p1=lip[i];
        }
        i++;
        }
         return p1;
        }
}
