
package exemploswitch;

public class metodos {
    public void comparar(String o){
        switch (o){
        case "1": System.out.println("Luns");
        break;
        case "2": System.out.println("Martes");
        break;
        case "3": System.out.println("Mercores");
        break;
        case "4": System.out.println("Xoves");
        break;
        case "5": System.out.println("Venres");
        break;
        case "6": System.out.println("Sabado");
        break;
        case "7": System.out.println("Domingo");
        break;
        default:System.out.println("Error, variable "+o+" introducida non valida");}
    }
}
