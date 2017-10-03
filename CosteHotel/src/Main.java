
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad =35;
		boolean carnet = true;
		boolean paro = true;
		double dinero = 0;

		if (edad < 30) {
			if (carnet == true && paro == true) {
				dinero = 35;
			} else if (carnet == true || paro == true) {
				dinero = 40;
			} else {
				dinero = 50;
			}
		} else if (edad > 55) {
			if (carnet == true || paro == true) {
				dinero = 45;
			} else {
				dinero = 60;
			}
		} else if ((edad >= 30 || edad <= 55)) {
			if (carnet == true || paro == true) {
				dinero = 65;
			} else {
				dinero = 75;
			}
		}

		System.out.println("Son " + dinero + "€");

	}
}
