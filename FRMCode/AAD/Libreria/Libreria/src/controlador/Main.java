package controlador;


import java.util.Scanner;
import modelo.bd.Alta;
import modelo.bd.Modificar;
import modelo.Libro;


/**
 *
 * @author a14damianld
 */
public class Main {
    
    public static void main(String[] args) {
        xerarMenu();
        Libro novoLibro = Libro(1, "asdf", "asdf", 2, null);
    }

    private static void xerarMenu() {
        Scanner entradaTeclado = new Scanner(System.in);
        byte eleccionMenu;
        do {
            vista.Menu.mostrarMenuPrincipal();
            eleccionMenu = entradaTeclado.nextByte();
            switch (eleccionMenu) {
                case 1:
                    Alta.autor();
                    break;
                case 2:
                    Alta.libro();
                    break;
                case 3:
                    Modificar.direccionAutor();
                    break;
                case 4:
                    Modificar.prezoLibro();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    System.out.println("Cerrouse o programa");
                    break;
                default:
                    System.err.println("Opción incorrecta, volves ó menu principal");
            }
        } while (eleccionMenu != 12);
    }

}
