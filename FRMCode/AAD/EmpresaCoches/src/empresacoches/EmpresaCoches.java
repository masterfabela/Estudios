/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacoches;

import java.sql.Connection;
import java.util.Scanner;
import metodos.*;
import org.hibernate.Session;
import sql.Creador;
import vista.Vista;

/**
 *
 * @author femio23
 */
public class EmpresaCoches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session sesion = NewHibernateUtil.getSession();
        Connection c = Creador.conexion();
        Altas a = new Altas();
        Modificacions m = new Modificacions();
        byte opcion = 0;
        while (opcion != 12) {
            Vista.menuPrincipal();
            opcion = sc.nextByte();
            switch (opcion) {
                case 1:
                    a.altaCoches();
                    break;
                case 2:
                    a.altaProveedores();
                    break;
                case 3:
                    m.asignarProveedor();
                    break;
                case 4:
                    a.altaReparacion();
                    break;
                case 5:
                    a.altaExposicion();
                    break;
                case 6:
                    m.asignarCocheExpo();
                    break;
                case 7:
                    a.altaCliente();
                    break;
                case 8:
                   m.venderCoche();
                    break;
                case 11:
                    Creador.purgaBase(c);
                    break;
                default:
                    if (opcion == 12) {
                        System.out.println("Adeus");
                    } else {
                        System.out.println("\n\nErro de entrada(1-12)\n\n\n");
                    }
                    break;
            }
        }
        sesion.close();
    }

}
