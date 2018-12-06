package exercicio5;
public class Exercicio5 {
    public static void main(String[] args) {
        MetodosSQL msql=new MetodosSQL();
        msql.conectar();
        msql.creador();
        msql.desconectar();
    }
    
}
