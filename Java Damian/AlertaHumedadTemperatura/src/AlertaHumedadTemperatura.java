
public class AlertaHumedadTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int humedad = 49;
		int temperatura = 24;

		if (humedad > 50 && temperatura > 24) {
			System.out.println("Alerta Roja");
		} else if (humedad > 50 || temperatura > 24) {
			System.out.println("Alerta Naranxa");
		} else {
			System.out.println("Alerta Verde");
		}
	}

}