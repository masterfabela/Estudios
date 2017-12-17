package boletin15;

public class Pteorica {
    private double n1,n2,mpt;

    public Pteorica() {
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getMpt() {
        return mpt;
    }

    public void setMpt(double mpt) {
        this.mpt = mpt;
    }
    
    public double cpteorica(){
        n1=(Math.random()*10)+1;
        n2=(Math.random()*10)+1;
        mpt=0.4*((n1+n2)/2);
        return mpt;
    }
}
