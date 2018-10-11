package programacomercio;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Metodos {
    
    Connection connv,connp,connpr;
    ArrayList<Prezos> pre=new ArrayList();
    ArrayList<Productos>pro=new ArrayList();
    ArrayList<Ventas>ven=new ArrayList();
    public void impfact(Ventas[]v,Productos[]pro,Prezos[]pre){
        System.out.println("Factura final");
        String aux;
        float c=0;
        for(int i=0;i<3;i++){
            System.out.print(v[i].nv+" --- ");
            aux=v[i].getRprod();
            for(int x=0;x<3;x++){
                if(aux.equals(pro[x].getRprod())){
                    System.out.print(pro[x].getNome()+" --- ");
                    aux=pro[x].getRprez();
                    for(int y=0;y<3;y++){
                        if(aux.equals(pre[y].getRprez())){
                            System.out.print(pre[y].getPrez()+"€/ud. subtotal:"+pre[y].getPrez()*v[i].getCant()+"\n");
                            c=c+pre[y].getPrez()*v[i].getCant();
                        }
                    }
                }
            }
            
        }
        System.out.println("Total: "+c);
    }
    public void searchelem(Ventas[]v,Productos[]pro,Prezos[]pre, String m){
        String aux=m;
        for(int i=0;i<3;i++){
            if(aux.equals(v[i].getNv())){
            System.out.println("Numero de venta do producto: "+v[i].nv);
            aux=v[i].getRprod();
            for(int x=0;x<3;x++){
                if(aux.equals(pro[x].getRprod())){
                    System.out.println("Nome do Producto: "+pro[x].getNome());
                    aux=pro[x].getRprez();
                    for(int y=0;y<3;y++){
                        if(aux.equals(pre[y].getRprez())){
                            System.out.println("Prezo unitario do producto: "+pre[y].getPrez()+"€");
                        }
                    }
                }
            }
        }
        }
    }
    public void conectar(){
        
        try {
            connv=DriverManager.getConnection("jdbc:sqlite:Ventas.sqlite3");
            connp=DriverManager.getConnection("jdbc:sqlite:Productos.sqlite3");
            connpr=DriverManager.getConnection("jdbc:sqlite:Prezos.sqlite3");
            if(connv!=null)
                System.out.println("Base de Ventas conectada.");
            if(connp!=null)
                System.out.println("Base de Productos conectada.");
            if(connpr!=null)
                System.out.println("Base de Prezos conectada.");
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }public void pechar(){
        try {
            connv.close();
            connp.close();
            connpr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargadatos(){
        ResultSet resul;
        try {
            PreparedStatement v = connv.prepareStatement("select * from Ventas;");
            resul=v.executeQuery();
            while(resul.next()){
            ven.add(new Ventas(resul.getString(1),resul.getString(2),resul.getInt(3)));
            }
            PreparedStatement pr = connp.prepareStatement("select * from Productos;");
            resul=pr.executeQuery();
            while(resul.next()){
            pro.add(new Productos(resul.getString(1),resul.getString(2),resul.getString(3)));
            }
            PreparedStatement pe = connpr.prepareStatement("select * from Prezos;");
            resul=pe.executeQuery();
            while(resul.next()){
            pre.add(new Prezos(resul.getString(1),resul.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
