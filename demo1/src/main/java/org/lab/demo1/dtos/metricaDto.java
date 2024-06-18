package org.lab.demo1.dtos;

public class metricaDto {
    private String aseguradora;
    private int cantidadAutos;
    private double sumaTarifas;
    private double sumaTotalPagada;

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getCantidadAutos() {
        return cantidadAutos;
    }

    public void setCantidadAutos(int cantidadAutos) {
        this.cantidadAutos = cantidadAutos;
    }

    public double getSumaTarifas() {
        return sumaTarifas;
    }

    public void setSumaTarifas(double sumaTarifas) {
        this.sumaTarifas = sumaTarifas;
    }

    public double getSumaTotalPagada() {
        return sumaTotalPagada;
    }

    public void setSumaTotalPagada(double sumaTotalPagada) {
        this.sumaTotalPagada = sumaTotalPagada;
    }

    // Getters y Setters
}
