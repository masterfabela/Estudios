package exemplo_atrib_obx;

public class Exemplo_atrib_obx {

    public static void main(String[] args) {
        Conta c1= new Conta("O de windows","8.8.8.8",100000000);
        System.out.println(c1.toString());
        Persoa p=new Persoa("Pobre","2222222");
        c1.setTitular(p);
        System.out.println(c1.toString());
    }
    
}
