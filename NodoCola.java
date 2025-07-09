/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class NodoCola {
    Expediente dato;
    NodoCola next;

    public NodoCola(Expediente dato) {
        this.dato = dato;
        this.next = null;
    }

    public Expediente getDato() {
        return dato;
    }

    public void setDato(Expediente dato) {
        this.dato = dato;
    }

    public NodoCola getNext() {
        return next;
    }

    public void setNext(NodoCola next) {
        this.next = next;
    }
    
    
}
