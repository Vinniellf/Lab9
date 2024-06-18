package org.lab.demo1.beans;

public class reserva {
    private int id_renta;
    private int auto_idauto;
    private int usuario_idusuario;
    private int seguro_idseguro;
    private String fecha_inicio;
    private String fecha_fin;
    private boolean cancelada;

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getAuto_idauto() {
        return auto_idauto;
    }

    public void setAuto_idauto(int auto_idauto) {
        this.auto_idauto = auto_idauto;
    }

    public int getUsuario_idusuario() {
        return usuario_idusuario;
    }

    public void setUsuario_idusuario(int usuario_idusuario) {
        this.usuario_idusuario = usuario_idusuario;
    }

    public int getSeguro_idseguro() {
        return seguro_idseguro;
    }

    public void setSeguro_idseguro(int seguro_idseguro) {
        this.seguro_idseguro = seguro_idseguro;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
}
