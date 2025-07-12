/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class Pila<T> {
    private NodoPila<T> tope;
    
    public boolean estaVacia() {
        return tope == null;
    }
    
    public void apilar(T dato){
        NodoPila<T> nuevo = new NodoPila(dato);
        nuevo.next = tope;
        tope = nuevo;
    }
    
    public T desapilar(){
        if (estaVacia()) {
            return null;
        }
        T dato = tope.dato;
        tope = tope.next;
        return dato;
        
    }
    public ListaSimple<T> obtenerComoLista() {
        ListaSimple<T> lista = new ListaSimple<>();
        NodoPila<T> actual = tope;
        while (actual != null) {
            lista.Agregar(actual.dato);
            actual = actual.next;
        }
        return lista;
    }
}
