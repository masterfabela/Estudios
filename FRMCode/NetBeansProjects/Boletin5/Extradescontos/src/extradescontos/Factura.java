package extradescontos;

public class Factura {
    double preciou;
    int cantidade;
    double bruto;
    public Factura(){}
    public void setp(double p){
    preciou=p;
    }
    public void setc(int c){
    cantidade=c;
    }
    public void facturar(Factura n){
        bruto=preciou*cantidade;
        System.out.println("Precio bruto= "+bruto);
    if (cantidade>=200&&preciou>=4000){
        bruto=bruto-bruto/10;
        System.out.println("Aplicase un desconto do 10%.\nO precio total a pagar="+bruto);
    }else{
    if (cantidade>=200){
    bruto=bruto-bruto*0.08;
        System.out.println("Aplicase un desconto do 8%.\nO precio total a pagar="+bruto);
    }else{
    if (cantidade<200&&cantidade>=100&&preciou>=4000){
    bruto=bruto-bruto*0.05;
        System.out.println("Aplicase un desconto do 5%.\nO precio total a pagar="+bruto);
    }else{
    if (cantidade<200&&cantidade>=100){
    bruto=bruto-bruto*0.02;
        System.out.println("Aplicase un desconto do 2%.\nO precio total a pagar="+bruto);
    }else{
        System.out.println("Non se aplican descontos.\nO precio total a pagar="+bruto);
    }
    }
    }
    }
    }
}
