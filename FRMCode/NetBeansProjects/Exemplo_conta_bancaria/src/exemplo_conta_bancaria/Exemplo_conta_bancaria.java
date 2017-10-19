
package exemplo_conta_bancaria;
import java.util.Scanner;
/*Enunciado
Codifica un programa para xestionar unha conta bancaria. Para iso, crea unha clase "conta" con 3 
atributos (nome, numero de conta e saldo, este ultimo, de tipo double), constructores por defecto 
e con parámetros, métodos de acceso para o número de conta, metodo para recivir o nome da conta
e 2 metodos para mudar o saldo, (metodo que reciva unha cantdade de cartos e os ingrese na nosa conta e 
devolva o saldo final e outro que reciva unha cantidade de cartos e o retire da nosa donta, 
devolvendo o saldo total(ainda que non haxa cartos na conta, permitese saldo negativo)), tamén se 
engadirá un metodo par a anular a conta, que será pasar a null os string e a os numericos o 
valer 0:
*/
public class Exemplo_conta_bancaria {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Conta Libreta1=new Conta();
        System.out.println(Libreta1.toString());
        Conta Libreta2=new Conta("Ana","222222",5000);
        Libreta1.setconta("111111");
        System.out.println(Libreta2.toString());
        Libreta1.setconta("1234");
        System.out.println(Libreta1.getconta());
        Libreta2.ingresar(500);
        Libreta1.retirar(500);
        //vamos a instanciar un obxeto "conta" con valores introducidos por teclado:
        System.out.println("Vai a crear unha conta nova, empece por introducir un nome.");
        String name=sc.nextLine();//introduce un string cos espacios.
        System.out.println("Agora introduza o seu numero de conta.");
        String nc=sc.next();
        System.out.println("E, para rematar, introduza o saldo inicial.");
        double s=sc.nextDouble();
        Conta Libreta3=new Conta(name,nc,s);
        System.out.println(Libreta3.toString());
        Libreta3.ingresar(3000);
        Libreta3.retirar(1000);
        Libreta3.retirar(3000);
        Libreta1.anulacion();//Pedir string por teclado, buscar contas
        Libreta2.anulacion();
        Libreta3.anulacion();
        System.out.println(Libreta1.getnome());
        System.out.println(Libreta2.getconta());
        System.out.println(Libreta3.getsaldo());
    }
    
}
