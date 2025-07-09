/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class NodoDoble<T> {
    T dato;
    NodoDoble<T> next;
    NodoDoble<T> prev;

    public NodoDoble(T dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }
    
}
