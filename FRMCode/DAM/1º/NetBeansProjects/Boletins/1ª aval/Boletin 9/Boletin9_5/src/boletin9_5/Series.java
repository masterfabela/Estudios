package boletin9_5;

public class Series {
    int valor;
    public Series(int n){
    valor=n;
    }
    public void cs(){
        System.out.print("Serie:\na) ");
        int m=2;
        System.out.print("2 ");
        for(int i=0;i<(valor-1);i++){
            
            System.out.print("+"+2*m+" ");
            m++;
        }
        System.out.print("\nb) ");
        m=-1;
        for(int i=0;i<(valor);i++){
            
            System.out.print(m+" ");
            if(m<0){
                m=(m-1)*(-1);
            }else{m=(m+1)*(-1);
            }
        }
        System.out.print("\nc) ");
        m=0;
        int m2=1, m3=1;
        System.out.print("0 ");
        for(int i=0;i<(valor-2);i++){
            
            System.out.print(m3+" ");
            m3=m2+m;
            m=m2;
            m2=m3;
            
            
        }
    }
    
}
