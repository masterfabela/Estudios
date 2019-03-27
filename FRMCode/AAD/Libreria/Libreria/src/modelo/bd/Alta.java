package modelo.bd;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Autor;
import modelo.Libro;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author a14damianld
 */
public class Alta {

    public static void autor() {
        Scanner entradaTeclado = new Scanner(System.in);
        ODB odb = ODBFactory.openClient("localhost", 8000, "libreria");
        String dni;
        String nombre;
        String direccion;
        int edad;
        String nacionalidad;
        Autor novoAutor = null;
        ArrayList<Libro> libro = null;
        System.out.println("Introduzca o DNI");
        dni = entradaTeclado.next();
        System.out.println("Introduzca un nome");
        nombre = entradaTeclado.next();
        System.out.println("Introduzca unha dirección");
        direccion = entradaTeclado.next();
        System.out.println("Introduzca a idade");
        edad = entradaTeclado.nextInt();
        System.out.println("Introduzca a nacionalidade");
        nacionalidad = entradaTeclado.next();

        novoAutor.setLibro(libro);
        novoAutor = new Autor(dni, nombre, direccion, edad, nacionalidad, libro);
        odb.store(novoAutor);
        odb.close();
    }

    public static void menuEngadirLibro() {
        Scanner entradaTeclado = new Scanner(System.in);
        byte opcionMenu;
        do {
            System.out.println("¿Desexa engadir libros ó autor?"
                + "\n 1.- Si"
                + "\n 2.- Non");
            opcionMenu = entradaTeclado.nextByte();
            switch (opcionMenu) {
                case 1:
                    engadirLibro();
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Opción incorrecta, volva a intentalo");
                    break;
            }
        } while (opcionMenu != 2);
    }
    
    public static void engadirLibro() {
        Libro novoLibro = Libro(1, "asdf", "asdf", 123, null);
        
    }

    public static void libro() {
        Scanner entradaTeclado = new Scanner(System.in);
        ODB odb = ODBFactory.openClient("localhost", 8000, "libreria");
        int codigo;
        String titulo;
        String categoria;
        float precio;
        Date fechaPublicacion;
        Libro novoLibro = null;
        fechaPublicacion = null;
        System.out.println("Introduzca o codigo do libro");
        codigo = entradaTeclado.nextInt();
        System.out.println("Introduzca o título do libro");
        titulo = entradaTeclado.next();
        System.out.println("Introduzca a categoria do libro");
        categoria = entradaTeclado.next();
        System.out.println("Indroduzca o prezo do libro");
        precio = entradaTeclado.nextFloat();
        novoLibro = new Libro(codigo, titulo, categoria, precio, fechaPublicacion);
        odb.store(novoLibro);
        odb.close();
    }

}
