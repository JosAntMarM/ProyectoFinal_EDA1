/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class NodoCircular<T> {
    T dato;
    NodoCircular next;

    public NodoCircular(T dato) {
        this.dato = dato;
        this.next = null;
    }
        
}
