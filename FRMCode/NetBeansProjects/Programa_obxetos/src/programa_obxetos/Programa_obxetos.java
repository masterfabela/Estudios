
package programa_obxetos;

public class Programa_obxetos {

    public static void main(String[] args) {
        Semaforo unSemaforo=new Semaforo();//instanciado de un obxeto de tipo semáforo.
        unSemaforo.ponCor("verde");
        System.out.println(unSemaforo.dimeCor());
        Semaforo outroSemaforo=new Semaforo();
        outroSemaforo.ponCor("vermello");
        System.out.println(outroSemaforo.dimeCor());
        
    }
    
}
