package com.example.solarsports.models;

public class PanelSolar {

    private int panelCount;
    String nombreterraza;
    String nombrelugar;

    public PanelSolar(String nombreterraza, String nombrelugar, float ancho, float longitud, float potencia, float horas, String mes, String categoria, String usuario) {
        this.nombreterraza = nombreterraza;
        this.nombrelugar = nombrelugar;
        this.ancho = ancho;
        this.longitud = longitud;
        this.potencia = potencia;
        this.horas = horas;
        this.mes = mes;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    float ancho;



    float longitud;



    float potencia;

    float horas;

    String mes;


    String categoria;

    public PanelSolar(String categoria, String usuario) {
        this.categoria = categoria;
        this.usuario = usuario;
    }

    String usuario;


    public String getNombrelugar() {
        return nombrelugar;
    }

    public void setNombrelugar(String nombrelugar) {
        this.nombrelugar = nombrelugar;
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


    public void incrementPanelCount() {
        panelCount++;
    }

    public int getPanelCount() {
        return panelCount;
    }

}
