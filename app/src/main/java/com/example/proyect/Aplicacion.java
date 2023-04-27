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

    public Aplicacion(String nombre, String elemento,String herramienta,  String medida,int codelines, int funciones, int metodos, int clases,int codesmells) {
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
    }
}
