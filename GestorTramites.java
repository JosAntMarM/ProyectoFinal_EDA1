/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author GotrixGamer
 */
public class GestorTramites {
    private ColaPrioridad colaPendientes;
    private ListaDoble<Expediente> listaRegistrados;
    private ListaCircular<Expediente> listaFinalizados;
    private NodoCircular<Expediente> punteroCircular;
    private static int contadorExpedientes = 1;
    private Pila<String> historial = new Pila<>();

    public GestorTramites() {
        this.colaPendientes = new ColaPrioridad();
        this.listaRegistrados = new ListaDoble<>();
        this.listaFinalizados = new ListaCircular<>();
        this.punteroCircular = null;
    }
    
    private String generarID(){
        String id = String.format("EXP%03d", contadorExpedientes);
        contadorExpedientes++;
        return id;
    }
    
    public void registrarExpediente(String prioridad, Interesado interesado, String asunto, Documento documentoRef){
        String id = generarID();
        Expediente nuevo = new Expediente(id, prioridad, interesado, asunto, documentoRef);
        colaPendientes.Insertar(nuevo);
        listaRegistrados.IngresarFinal(nuevo);
        historial.apilar("Se registró expediente: " + nuevo.getId());
        nuevo.setDocumentoRef(documentoRef);
        System.out.println("Expediente registrado con ID: " + id);
    }
    
    private void actualizarPunteroCircular(){
        this.punteroCircular = listaFinalizados.getPrimero();
    }
    
    public boolean finalizarExpediente(String id){
        NodoDoble<Expediente> it = listaRegistrados.getHead();
        while(it != null){
            Expediente e = it.dato;
            if (e.getId().equalsIgnoreCase(id)) {
                if (e.estarFinalizado()) {
                    return false;
                }
                e.finalizarTramite();
                listaFinalizados.Agregar(e);
                colaPendientes.eliminarPorId(id);
                historial.apilar("Se finalizó expediente: " + e.getId());
                actualizarPunteroCircular();
                return true;              
            }
            it = it.next;
        }
        System.out.println("No se encontre expediente con ID: " + id);
        return false;
    }
    
    public Expediente verExpediente(String id){
        NodoDoble<Expediente> it = listaRegistrados.getHead();
        while(it != null){
            if (it.dato.getId().equals(id)) {
                return it.dato;
            }
            it = it.next;
        }
        return null;
    }
    
    public void mostrarExpediente(){
        System.out.println("Expedientes pendientes (por prioridad y antigüedad):");
        colaPendientes.ImprimirCola();
    }
    
    public Expediente alertaSiguiente(){
        if (punteroCircular == null) {
            return null;
        }
        Expediente next = punteroCircular.dato;
        punteroCircular = punteroCircular.next;
        return next;
    }
    
    public ListaSimple<Expediente> obtenerPendientesComoLista() {
        ListaSimple<Expediente> lista = new ListaSimple<>();
        ColaPrioridad copia = colaPendientes.Copiar();
        Expediente e;
        while((e = copia.atender()) != null){
            lista.Agregar(e);
        }
        return lista;
    }

    public Pila<String> getHistorial() {
        return historial;
    }

    public void setHistorial(Pila<String> historial) {
        this.historial = historial;
    }
    
    
    public ColaPrioridad getColaPendientes() {
        return colaPendientes;
    }

    public void setColaPendientes(ColaPrioridad colaPendientes) {
        this.colaPendientes = colaPendientes;
    }

    public ListaDoble<Expediente> getListaRegistrados() {
        return listaRegistrados;
    }

    public void setListaRegistrados(ListaDoble<Expediente> listaRegistrados) {
        this.listaRegistrados = listaRegistrados;
    }

    public ListaCircular<Expediente> getListaFinalizados() {
        return listaFinalizados;
    }

    public void setListaFinalizados(ListaCircular<Expediente> listaFinalizados) {
        this.listaFinalizados = listaFinalizados;
    }

    public NodoCircular<Expediente> getPunteroCircular() {
        return punteroCircular;
    }

    public void setPunteroCircular(NodoCircular<Expediente> punteroCircular) {
        this.punteroCircular = punteroCircular;
    }

    public static int getContadorExpedientes() {
        return contadorExpedientes;
    }

    public static void setContadorExpedientes(int contadorExpedientes) {
        GestorTramites.contadorExpedientes = contadorExpedientes;
    }
    
}
