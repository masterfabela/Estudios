package alumno;

public class Datosacademicos {
  String referencia;
  int nota;  
  public void setreferencia(String r){
   referencia=r;
   }
   public void setnota(int n){
   nota=n;
   }
   public String getreferencia(){
   return referencia;
   }
   public int getnota(){
   return nota;
   }
   public Datosacademicos(){}
   public Datosacademicos(String r, int n){
      referencia=r;
      nota=n;
   }
}
