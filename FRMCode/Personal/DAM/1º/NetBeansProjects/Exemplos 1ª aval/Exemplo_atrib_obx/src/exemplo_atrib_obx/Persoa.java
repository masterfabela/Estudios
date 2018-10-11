
package exemplo_atrib_obx;

public class Persoa {
 String nome;
 String dni;
 public Persoa(){
 };
 
 public Persoa(String n, String d){
     nome=n;
     dni=d;
 };
 public void setnome(String n){
     nome=n;
 }
 public void setdni(String d){
     dni=d;
 }
 public String getnome(){  
     return nome;
 }
 
 public String getdni(){
     return dni;
 }
 @Override
 public String toString(){
     return("Os datos do propietario son os seguintes:\nNome:"+nome
             +".\nDocumento nacional de identidade:"+dni+".");
 }
}
