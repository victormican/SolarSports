package com.example.solarsports.models;

public class Estadisticas {

    float Promedio;
    float Ahorro;

    String Categoria;

    String Mes;
    public float getPromedio() {
        return Promedio;
    }

    public void setPromedio(float promedio) {
        Promedio = promedio;
    }

    public float getAhorro() {
        return Ahorro;
    }

    public void setAhorro(float ahorro) {
        Ahorro = ahorro;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }



    public Estadisticas(float promedio, float ahorro, String categoria, String mes) {
        Promedio = promedio;
        Ahorro = ahorro;
        Categoria = categoria;
        Mes = mes;
    }


}
