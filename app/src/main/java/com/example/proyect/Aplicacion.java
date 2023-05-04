package com.example.proyect;

public class Aplicacion {
    public String nombre;
    public String elemento;
    public String herramienta;
    public String medida;
    public String tamaño;
    public int codelines;
    public int funciones;
    public int metodos;
    public int clases;
    public int codesmells;
    public int concretas;
    public int abstractas;

    public Aplicacion(String nombre, String elemento ,String herramienta, String medida, String tamaño, int codelines, int funciones, int metodos, int clases,
                      int codesmells, int concretas, int abstractas) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.herramienta = herramienta;
        this.medida = medida;
        this.tamaño = tamaño;
        this.codelines = codelines;
        this.funciones = funciones;
        this.metodos = metodos;
        this.clases = clases;
        this.codesmells = codesmells;
        this.concretas = concretas;
        this.abstractas = abstractas;
    }
    public Aplicacion() {
    }

/*public Aplicacion(String nombre, String elemento,String herramienta,  String medida,int codelines, int funciones, int metodos, int clases,int codesmells) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.herramienta = herramienta;
        this.medida = medida;
        this.tamaño = tamaño;
        this.codelines = codelines;
        this.funciones = funciones;
        this.metodos = metodos;
        this.clases = clases;
        this.codesmells = codesmells;
        this.concretas = 0;
        this.abstractas = 0;
    }*/

    public String getNombre() {
        return nombre;
    }

    public String getElemento() {
        return elemento;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public String getMedida() {
        return medida;
    }

    public String getTamaño() {
        return tamaño;
    }

    public int getCodelines() {
        return codelines;
    }

    public int getFunciones() {
        return funciones;
    }

    public int getMetodos() {
        return metodos;
    }

    public int getClases() {
        return clases;
    }

    public int getCodesmells() {
        return codesmells;
    }

    public int getConcretas() {
        return concretas;
    }

    public int getAbstractas() {
        return abstractas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setCodelines(int codelines) {
        this.codelines = codelines;
    }

    public void setFunciones(int funciones) {
        this.funciones = funciones;
    }

    public void setMetodos(int metodos) {
        this.metodos = metodos;
    }

    public void setClases(int clases) {
        this.clases = clases;
    }

    public void setCodesmells(int codesmells) {
        this.codesmells = codesmells;
    }

    public void setConcretas(int concretas) {
        this.concretas = concretas;
    }

    public void setAbstractas(int abstractas) {
        this.abstractas = abstractas;
    }
}
