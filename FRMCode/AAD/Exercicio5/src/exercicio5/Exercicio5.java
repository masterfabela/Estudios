package exercicio5;


import org.hibernate.Session;

public class Exercicio5 {
    public static void main(String[] args) {
        MetodosSQL msql=new MetodosSQL();
        msql.conectar();
        Session sesion=NewHibernateUtil.getSession();
        msql.desconectar();
    }
    
}
