package com.example.solarsports.models;

public class Canchas {

    String nombrecancha;
    float preciokw;

    float consumo;
    String mes;


    public String getNombrecancha() {
        return nombrecancha;
    }

    public void setNombrecancha(String nombrecancha) {
        this.nombrecancha = nombrecancha;
    }

    public float getPreciokw() {
        return preciokw;
    }

    public void setPreciokw(float preciokw) {
        this.preciokw = preciokw;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }


    public Canchas(String nombrecancha, float preciokw, float consumo, String mes) {
        this.nombrecancha = nombrecancha;
        this.preciokw = preciokw;
        this.consumo = consumo;
        this.mes = mes;
    }

    public Canchas(float preciokw, float consumo, String mes) {
        this.preciokw = preciokw;
        this.consumo = consumo;
        this.mes = mes;
    }
}
