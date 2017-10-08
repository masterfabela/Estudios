
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 5;
		int num2 = 3;
		int num3 = 6;

		if (num1 > num2 && num1 > num3) {
			System.out.println("El numero más grande es: " + num1);
		} else if (num2 > num3 && num2 > num1) {
			System.out.println("El numero más grande es: " + num2);
		} else if (num3 > num2 && num3 > num1) {
			System.out.println("El numero más grande es: " + num3);
		}
	}
}