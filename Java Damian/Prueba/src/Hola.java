import java.util.Scanner;

public class Hola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

		 // Usamos como delimitador el dos puntos, o bien cualquier
		 // espacio/fin de línea (el \\s)
		 sc.useDelimiter("[:\\s]");

		 // Le pedimos al usuario que escriba su nombre
		 System.out.print("Por favor, escriba su nombre: ");
		 
		 // Leer el nombre del usuario
		 String nombre = sc.nextLine();

		 // Obtenemos el nombre
		 System.out.println("Bienvenido a nuestra app "+nombre+"\n");
		 
		 // Mostramos al usuario las opciones del menú
		 System.out.println("***** APP REMIX OPERACIONES ****\n"
		 		+ "* 1. Realizar una suma\n"
				+ "* 2. Paridad \n"
		 		+ "* 3. Número primo\n"
				+ "* 4. Generados nºs primos\n"
				+"**********************\n");
		 
		 System.out.print("Indique una opción del menú: ");
		 int seleccionMenu = sc.nextInt();
		 
		 if(seleccionMenu==1) {
			 System.out.println("Ha selecciona la operación suma");
			 suma();
		 } else if(seleccionMenu==2) {
			 System.out.println("Ha selecciona la operación paridad");
			 paridad();
		 } else if(seleccionMenu==3) {
			 System.out.println("Ha selecciona la operación número primo");
			 primo();
		 } else if(seleccionMenu==4) {
			 System.out.println("Ha selecciona la operación de generar nºs primos");
			 generadorPrimos();
		 } else {
			 System.out.println("NO HA SELECCIONA UNA OPCIÓN VÁLIDA");
		 }

	}
	
	

	private static void generadorPrimos() {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
		
		System.out.print("Indique cuántos nºs primos desea generar: ");
		int numerosPrimos = sc.nextInt();
		
		int contador = 0, i=1;
		while(contador<numerosPrimos) {
			if(esPrimo(i)) {
				System.out.println(contador+1+": "+i+" ");
				contador++;
			}
			
			i++;
		}
		
	}



	private static void primo() {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[:\\s]");
	
		System.out.print("Indique sobre qué nº quiere consultar la si es primo: ");
		int numero = sc.nextInt();
		
		
		if(esPrimo(numero)) {
			System.out.println("El número "+numero+" es primo");
		} else {
			System.out.println("El número "+numero+" NO es primo");
		}
				
	}

	private static boolean esPrimo(int numero) {
		boolean elNumeroEsPrimo = true;
		for(int i=2; i<numero; i++) {
			if(numero%i==0) {
				elNumeroEsPrimo = false;
				break;
			}
		}
		
		return elNumeroEsPrimo;
	}



	private static void paridad() {
		Scanner sc = new Scanner(System.in);
		 sc.useDelimiter("[:\\s]");
		 
		 System.out.print("Indique sobre qué nº quiere consultar la paridad: ");
		 int numero = sc.nextInt();
		 
		 // Para saber si un número es par, simplemente hay que saber
		 // si el resto de realizar la división entre 2 de dicho 
		 // número es igual a 0
		 if(numero%2==0) {
			 System.out.println("El número "+numero+" es par");
		 } else {
			 System.out.println("El número "+numero+" es impar");
		 }
		
	}

	private static void suma() {
		Scanner sc = new Scanner(System.in);
		 sc.useDelimiter("[:\\s]");
		 
		System.out.print("Indique cuál es el operando 1: ");
		int op1 = sc.nextInt();
		
		System.out.print("Indique cuál es el operando 2: ");
		int op2 = sc.nextInt();
		
		int resultadoSuma = op1+op2;
		System.out.print("El resultado de "+op1+"+"+op2+"="+resultadoSuma);
		
	}

}
