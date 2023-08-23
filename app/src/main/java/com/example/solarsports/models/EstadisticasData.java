package com.example.solarsports.models;


public class EstadisticasData {
    private String nombre;
    private float consumo;
    private float valorkW;
    private String mes;
    private String usuario;
    private String categoria;

    public EstadisticasData(String nombre, float consumo, float valorkW, String mes, String usuario, String categoria) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.valorkW = valorkW;
        this.mes = mes;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public float getConsumo() {
        return consumo;
    }

    public float getValorkW() {
        return valorkW;
    }

    public String getMes() {
        return mes;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCategoria() {
        return categoria;
    }
}