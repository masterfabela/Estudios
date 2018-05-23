/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectosql;
/**
 *
 * @author femio23
 */
public class ProxectoSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector con1=new Conector();
        //con1.consultar("select * from EquipoProg;");
        //con1.insertar("Pepe",25,"4");
        //con1.actualizar("update EquipoProg set codigo='c04' where codigo=4");
        //con1.borrar("delete from EquipoProg where codigo='c04';");
        //con1.consultar("select * from EquipoProg;");
        Venta v1=new Venta(con1);

    }
    
}
