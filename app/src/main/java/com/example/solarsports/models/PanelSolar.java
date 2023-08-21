package com.example.solarsports.models;

public class PanelSolar {

    float ancho;
    float longitud;

    float potencia;

    float horas;

    String mes;

    String nombreterraza;

    String categoria;


    public PanelSolar(float ancho, float longitud, float potencia, float horas, String mes, String nombreterraza, String categoria, String usuario) {
        this.ancho = ancho;
        this.longitud = longitud;
        this.potencia = potencia;
        this.horas = horas;
        this.mes = mes;
        this.nombreterraza = nombreterraza;
        this.categoria = categoria;
        this.usuario = usuario;
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

    public PanelSolar(float ancho, float longitud, float potencia, float horas, String mes, String nombreterraza, String usuario) {
        this.ancho = ancho;
        this.longitud = longitud;
        this.potencia = potencia;
        this.horas = horas;
        this.mes = mes;
        this.nombreterraza = nombreterraza;
        this.usuario = usuario;
    }

    private String usuario;





    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNombreterraza() {
        return nombreterraza;
    }

    public void setNombreterraza(String nombreterraza) {
        this.nombreterraza = nombreterraza;
    }



    public PanelSolar(float ancho, float longitud, float potencia, float horas, String mes, String nombreterraza) {
        this.ancho = ancho;
        this.longitud = longitud;
        this.potencia = potencia;
        this.horas = horas;
        this.mes = mes;
        this.nombreterraza = nombreterraza;
    }
}
