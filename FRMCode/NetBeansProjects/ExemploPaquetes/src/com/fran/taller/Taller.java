package com.fran.taller;
import exemplopaquetes.Coches;

/**
 *
 * @author femio23
 */
public class Taller {
    private Coches coche;
    private float factura;

    public Taller(Coches coche, float factura) {
        this.coche = coche;
        this.factura = factura;
    }

    public Taller() {
    }

    public Coches getCoche() {
        return coche;
    }

    public void setCoche(Coches coche) {
        this.coche = coche;
    }

    public float getFactura() {
        return factura;
    }

    public void setFactura(float factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Taller{" + "coche=" + coche + ", factura=" + factura + '}';
    }
    public void desconto(Coches c1,Coches c2){
        if(c1.getMatricula().equals(c2.getMatricula())){
            factura=0.8f*factura;
            System.out.println("Foi mercado neste concesionario.");
    }else{
            System.out.println("Non foi mercado neste concesionario");
        }
    }
}
