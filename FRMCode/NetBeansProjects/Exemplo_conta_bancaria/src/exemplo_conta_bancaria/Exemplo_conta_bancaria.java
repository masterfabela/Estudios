
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
        Scanner sc=new Scanner(System.out);
        Conta c1=new Conta();
        Conta c2=new Conta("Fran","123456",200539);
        System.out.println(c1.getconta());
        System.out.println(c2.getconta());
        System.out.println(c1.getnome());
        System.out.println(c2.getnome());
        c2.ingresar(500);
        c1.retirar(500);

    }
    
}
