package programacomercio;

public class Metodos {
    public void impfact(Ventas[]v,Productos[]pro,Prezos[]pre){
        String aux;
        int c=0;
        for(int i=0;i<3;i++){
            System.out.println(v[i].nv);
            aux=v[i].getRprod();
            for(int x=0;x<3;x++){
                if(aux.equals(pro[x].getRprod())){
                    System.out.println(pro[x].getNome());
                    aux=pre[x].getRprez();
                    System.out.println(aux);
//                    for(int y=0;y<3;y++){
//                        if(aux.equals(pre[y].getRprez())){
//                            System.out.println(pre[y].getPrez());
//                        }
//                    }
                }else{
                    System.out.println(aux+pro[x].getRprod());
                }
            }
            
        }
    }
    public void searchelem(){

    }
}
