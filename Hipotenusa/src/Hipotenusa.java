
public class Hipotenusa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double catetoa=30;
		double catetob=45;
		double hipotenusa;
		
		double a2=Math.pow(catetoa, 2);
		double b2=Math.pow(catetob, 2);
		
		hipotenusa=Math.sqrt(a2+b2);
		
		System.out.println(hipotenusa);
	}

}
