
package exemplo_conta_bancaria;
import java.util.Scanner;
/*Enunciado
Codifica un programa para xestionar unha conta bancaria. Para iso, crea unha clase "conta" con 3 
atributos (nome, numero de conta e saldo, este ultimo, de tipo double), constructores por defecto 
e con parámetros, métodos de acceso para o número de conta, metodo para recivir o nome da conta
e 2 metodos para mudar o saldo, (metodo que reciva unha cantdade de cartos e os ingrese na nosa conta e 
devolva o saldo final e outro que reciva unha cantidade de cartos e o retire da nosa donta, 
devolvendo o saldo total(ainda que non haxa cartos na conta, permitese saldo negativo))
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

    }
    
}
