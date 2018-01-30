package exemploarraylist;

import java.util.*;
import javax.swing.JOptionPane;

public class Metodos {
    public void engadir (ArrayList<Integer> lis){
        lis.add(Integer.parseInt(JOptionPane.showInputDialog("Introduza o enteiro que desexa engadir")));
    }
    public void borrarit (ArrayList<Integer> lis){
        Iterator it=lis.iterator();
        while(it.hasNext())
            System.out.println("Vaise eliminar "+it.next());
        it.remove();
    }
    public void amosarit (ArrayList<Integer> lis){
        Iterator it=lis.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
