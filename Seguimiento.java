/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

import java.time.LocalDateTime;

/**
 *
 * @author GotrixGamer
 */
public class Seguimiento {
    private String dependenciaDestino;
    private LocalDateTime fechaHoraMovimiento;
    private String observaciones;

    public Seguimiento(String dependenciaDestino, LocalDateTime fechaHoraMovimiento, String observaciones) {
        this.dependenciaDestino = dependenciaDestino;
        this.fechaHoraMovimiento = fechaHoraMovimiento;
        this.observaciones = observaciones;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public void setDependenciaDestino(String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public LocalDateTime getFechaHoraMovimiento() {
        return fechaHoraMovimiento;
    }

    public void setFechaHoraMovimiento(LocalDateTime fechaHoraMovimiento) {
        this.fechaHoraMovimiento = fechaHoraMovimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
