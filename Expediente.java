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
public class Expediente {
    private String id;
    private String prioridad;
    private Interesado interesado;
    private String asunto;
    private Documento documentoRef;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private ListaSimple<Documento> documentosGenerado;
    private ListaSimple<Seguimiento> historialSeguimiento;
    private boolean finalizado = false;
    

    public Expediente(String id, String prioridad, Interesado interesado, String asunto, Documento documentoRef) {
        this.id = id;
        this.prioridad = prioridad;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documentoRef = documentoRef;
        this.fechaInicio = LocalDateTime.now();
        this.documentosGenerado = new ListaSimple<>();
        this.historialSeguimiento = new ListaSimple<>();
    }

    
    
    @Override
    public String toString(){
        return id + " - " + asunto + " (" + prioridad + ")";
    }

    public void finalizarTramite(){
        this.fechaFin = LocalDateTime.now();
        this.finalizado = true;
    }
    
    public boolean estarFinalizado(){
        return finalizado;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Documento getDocumentoRef() {
        return documentoRef;
    }

    public void setDocumentoRef(Documento documentoRef) {
        this.documentoRef = documentoRef;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ListaSimple<Documento> getDocumentosGenerado() {
        return documentosGenerado;
    }

    public void setDocumentosGenerado(ListaSimple<Documento> documentosGenerado) {
        this.documentosGenerado = documentosGenerado;
    }

    public ListaSimple<Seguimiento> getHistorialSeguimiento() {
        return historialSeguimiento;
    }

    public void setHistorialSeguimiento(ListaSimple<Seguimiento> historialSeguimiento) {
        this.historialSeguimiento = historialSeguimiento;
    }   
    
}
