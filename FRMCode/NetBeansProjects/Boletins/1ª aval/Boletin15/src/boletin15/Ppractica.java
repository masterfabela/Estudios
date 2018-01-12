package boletin15;

public class Ppractica {
    double n,mpp;

    public Ppractica() {
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getMpp() {
        return mpp;
    }

    public void setMpp(double mpp) {
        this.mpp = mpp;
    }
    
    public double cpractica(){
    n=(Math.random()*10)+1;
    mpp=0.4*n;
    return mpp;
    }
}
