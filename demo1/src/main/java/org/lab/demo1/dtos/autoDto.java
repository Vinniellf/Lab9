package org.lab.demo1.dtos;

public class autoDto {
    private int id;
    private String modelo;
    private String color;
    private int kilometraje;
    private double costo_por_dia;
    private String distrito;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public double getCosto_por_dia() {
        return costo_por_dia;
    }

    public void setCosto_por_dia(double costo_por_dia) {
        this.costo_por_dia = costo_por_dia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters y Setters
}