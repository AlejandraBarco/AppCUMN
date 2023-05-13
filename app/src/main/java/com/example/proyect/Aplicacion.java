package com.example.proyect;

public class Aplicacion {
    public String nombre;
    public String elemento;
    public String herramienta;
    public String medida;
    public String tamaño;
    public int codelines;
    public int sentencias;
    public int metodos;
    public int clases;
    public int codesmells;
    public int concretas;

    public int abstractas;

    public int duplicatedLines;

    public int duplicatedFiles;

    public Double cpu;
    public String key;



    public Aplicacion(String nombre, String elemento , String herramienta, String medida, String tamaño, int codelines, int sentencias, int metodos, int clases,
                      int codesmells, int concretas, int abstractas, int duplicatedLines, int duplicatedFiles, Double cpu, String key) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.herramienta = herramienta;
        this.medida = medida;
        this.tamaño = tamaño;
        this.codelines = codelines;
        this.sentencias = sentencias;
        this.metodos = metodos;
        this.clases = clases;
        this.codesmells = codesmells;
        this.concretas = concretas;
        this.abstractas = abstractas;
        this.duplicatedLines = duplicatedLines;
        this.duplicatedFiles = duplicatedFiles;
        this.cpu = cpu;
        this.key = key;
    }
    public Aplicacion() {
    }

/*public Aplicacion(String nombre, String elemento,String herramienta,  String medida,int codelines, int funciones, int metodos, int clases,int codesmells, int CPU) {
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

    public int getSentencias() {
        return sentencias;
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

    public int getDuplicatedLines() {
        return duplicatedLines;
    }

    public int getDuplicatedFiles() {
        return duplicatedFiles;
    }

    public Double getCpu() {
        return cpu;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setDuplicatedLines(int duplicatedLines) {
        this.duplicatedLines = duplicatedLines;
    }

    public void setDuplicatedFiles(int duplicatedFiles) {
        this.duplicatedFiles = duplicatedFiles;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
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

    public void setSentencias(int sentencias) {
        this.sentencias = sentencias;
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
