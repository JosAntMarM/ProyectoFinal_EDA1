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
        System.out.println("Expediente registrado con ID: " + id);
    }
    
    private void actualizarPunteroCircular(){
        this.punteroCircular = listaFinalizados.getPrimero();
    }
    
    public boolean finalizarExpediente(String id){
        NodoDoble<Expediente> it = listaRegistrados.getHead();
        while(it != null){
            Expediente e = it.dato;
            if (e.getId().equals(id)) {
                e.finalizarTramite();
                listaFinalizados.Agregar(e);
                actualizarPunteroCircular();
                System.out.println("Expediente finzalido: " + id);
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
}
