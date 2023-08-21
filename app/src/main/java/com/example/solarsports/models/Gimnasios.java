package com.example.solarsports.models;

public class Gimnasios {

    String nombregim;
    float valorkw;
    float consumo;
    String mes;

    String usuario;

    String categoria;

    public Gimnasios(String nombregim, float valorkw, float consumo, String mes, String usuario, String categoria) {
        this.nombregim = nombregim;
        this.valorkw = valorkw;
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



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }



    public Gimnasios(String nombregim, float valorkw, float consumo, String mes, String usuario) {
        this.nombregim = nombregim;
        this.valorkw = valorkw;
        this.consumo = consumo;
        this.mes = mes;
        this.usuario = usuario;
    }


    public String getNombregim() {
        return nombregim;
    }

    public void setNombregim(String nombregim) {
        this.nombregim = nombregim;
    }

    public float getValorkw() {
        return valorkw;
    }

    public void setValorkw(float valorkw) {
        this.valorkw = valorkw;
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

    public Gimnasios(float valorkw, float consumo, String mes) {
        this.valorkw = valorkw;
        this.consumo = consumo;
        this.mes = mes;
    }

    public Gimnasios(String nombregim, float valorkw, float consumo, String mes) {
        this.nombregim = nombregim;
        this.valorkw = valorkw;
        this.consumo = consumo;
        this.mes = mes;
    }
}
