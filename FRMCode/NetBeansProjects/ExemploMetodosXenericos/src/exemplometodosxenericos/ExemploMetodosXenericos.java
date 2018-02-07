package exemplometodosxenericos;

import java.util.ArrayList;

public class ExemploMetodosXenericos {

    public static void main(String[] args) {
        ArrayList <Correo>c1=new ArrayList();
        ArrayList <Libro>l1=new ArrayList();
        ArrayList <Personal>p1=new ArrayList();
        c1.add(new Correo("Bos dias",true));
        c1.add(new Correo("Boas tardes",false));
        c1.add(new Correo("Ofensa",false));
        l1.add(new Libro("La Celestina","2590Rº","Desconocido",20.5f,3));
        p1.add(new Personal("chs@gmail.com","651"));
        Metodos.amosar(l1);
        Metodos.amosar(c1);
        Metodos.amosar(p1);
        Metodos.eliminar(c1, 2);
        Metodos.amosar(c1);
    }
    
}
