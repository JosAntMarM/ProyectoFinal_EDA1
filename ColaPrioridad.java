/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class ColaPrioridad {
    private NodoCola frente;

    public ColaPrioridad() {
        this.frente = frente;
    }
    
    public boolean Vacio(){
        return frente == null;
    }
    
    private int prioridadValor(String prioridad){
        return switch (prioridad.toLowerCase()){
            case "alta" -> 3;
            case "media" -> 2;
            case "baja" -> 1;
            default -> 0;
        };
    }
    
    private boolean debeIrAntes(Expediente e1, Expediente e2){
        int p1 = prioridadValor(e1.getPrioridad());
        int p2 = prioridadValor(e2.getPrioridad());
        if (p1 > p2) {
            return true;
        }
        if (p2 > p1) {
            return false;
        }
        return e1.getFechaInicio().isBefore(e1.getFechaInicio());
    }
    
    public void Insertar(Expediente nuevo){
        NodoCola nodoNuevo = new NodoCola(nuevo);
        if (frente == null || debeIrAntes(nuevo, frente.dato)) {
            nodoNuevo.next = frente;
            frente = nodoNuevo;
        }
        else{
            NodoCola it = frente;
            while(it.next != null && !debeIrAntes(nuevo, it.next.dato)){
                it = it.next;
            }
            nodoNuevo.next = it.next;
            it.next = nodoNuevo;
        }
    }
    
    public Expediente atender(){
        if (Vacio()) {
            return null;
        }
        Expediente dato = frente.dato;
        frente = frente.next;
        return dato;
    }
    
    public Expediente verPrimero(){
        return Vacio() ? null : frente.dato;
    }
    
    public void ImprimirCola(){
        NodoCola it = frente;
        while(it != null){
            Expediente e = it.dato;
            System.out.println("[" + e.getPrioridad() + "]" + e.getInteresado().getNombres() + " - " + e.getAsunto());
            it = it.next;
        }
    }
    
    public ColaPrioridad Copiar(){
        ColaPrioridad nueva = new ColaPrioridad();
        NodoCola it = this.frente;
        while(it != null){
            nueva.Insertar(it.dato);
            it = it.next;
        }
        return nueva;
    }
    
    public void eliminarPorId(String id){
        ColaPrioridad nuevaCola = new ColaPrioridad();
        NodoCola it = this.frente;
        while(it != null){
            if (!it.dato.getId().equalsIgnoreCase(id)) {
                nuevaCola.Insertar(it.dato);
            }
            it = it.next;
        }
        this.frente = nuevaCola.frente;
    }
    
}
