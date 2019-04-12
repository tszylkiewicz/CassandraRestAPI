package model;

import org.springframework.data.cassandra.mapping.Table;

@Table("tirePressure")
public class TirePreassure {
    private float rf;
    private float lf;
    private float rr;
    private float lr;

    public TirePreassure() {
        super();
    }

    public TirePreassure(float rf, float lf, float rr, float lr) {
        super();
        this.rf = rf;
        this.lf = lf;
        this.rr = rr;
        this.lr = lr;
    }

    public float getRf() {
        return rf;
    }

    public void setRf(float rf) {
        this.rf = rf;
    }

    public float getLf() {
        return lf;
    }

    public void setLf(float lf) {
        this.lf = lf;
    }

    public float getRr() {
        return rr;
    }

    public void setRr(float rr) {
        this.rr = rr;
    }

    public float getLr() {
        return lr;
    }

    public void setLr(float lr) {
        this.lr = lr;
    }
}
