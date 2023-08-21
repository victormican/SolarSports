package com.example.solarsports.models;

public class Canchas {

    String nombrecancha;
    float preciokw;

    float consumo;
    String mes;
    String usuario;

    public Canchas(String nombrecancha, float preciokw, float consumo, String mes, String usuario, String categoria) {
        this.nombrecancha = nombrecancha;
        this.preciokw = preciokw;
        this.consumo = consumo;
        this.mes = mes;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    String  categoria;
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }



    public Canchas(String nombrecancha, float preciokw, float consumo, String mes, String usuario) {
        this.nombrecancha = nombrecancha;
        this.preciokw = preciokw;
        this.consumo = consumo;
        this.mes = mes;
        this.usuario = usuario;
    }




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


    public Canchas(float consumo, float preciokw, String mes, String usuario) {
        this.consumo = consumo;
        this.preciokw = preciokw;
        this.mes = mes;
        this.usuario = usuario;
    }

    public Canchas(float preciokw, float consumo, String mes) {
        this.preciokw = preciokw;
        this.consumo = consumo;
        this.mes = mes;
    }
}
