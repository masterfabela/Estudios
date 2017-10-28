package alumno;

public class Datospersoais {
   String direccion;
   String tlfn;
   public void setdireccion(String d){
   direccion=d;
   }
   public void settlfn(String t){
   tlfn=t;
   }
   public String getdireccion(){
   return direccion;
   }
   public String gettlfn(){
   return tlfn;
   }
   public Datospersoais(){

   }
   public Datospersoais(String d,String t){
    direccion=d;
    tlfn=t;
       }   
}
