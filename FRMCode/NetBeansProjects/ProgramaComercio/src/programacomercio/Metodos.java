package programacomercio;

public class Metodos {
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
}
