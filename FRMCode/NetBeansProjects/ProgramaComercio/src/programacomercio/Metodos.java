package programacomercio;

public class Metodos {
    public void impfact(Ventas[]v,Productos[]pro,Prezos[]pre){
        String aux;
        int c=0;
        for(int i=0;i<3;i++){
            System.out.println(v[i].nv);
            aux=v[i].rprod;
            for(int x=0;x<3;x++){
                if(aux.equals(pro[x].rprod)){
                    System.out.println(pro[x].nome);
                    aux=pre[x].rprez;
                    for(int y=0;y<3;y++){
                        if(aux.equals(pre[y].rprez)){
                            System.out.println(pre[y].prez);
                        }
                    }
                }
            }
            
        }
    }
    public void searchelem(){

    }
}
