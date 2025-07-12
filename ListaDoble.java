/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class ListaDoble<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean Vacio(){
        return size == 0;
    }
    
    public int Tamaño(){
        return size;
    }
    
    public void IngresarInicio(T dato){
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (Vacio()) {
            head = nuevo;
            tail = nuevo;
        }
        else{
            tail.next = nuevo;
            nuevo.prev = tail;
            tail = nuevo;
        }
        size++;
    }
    
    public void IngresarFinal(T dato){
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (Vacio()) {
            head = nuevo;
            tail = nuevo;
        }
        else{
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
        }
        size++;
    }
    
    public void ImprimirDesdeInicio(){
        NodoDoble<T> it = head;
        while(it != null){
            System.out.println(it.dato.toString());
            it = it.next;    
        }
    }
    
    public void ImprimirDesdeFin(){
        NodoDoble<T> it = tail;
        while(it != null){
            System.out.println(it.dato.toString());
            it=it.prev;
        }
    }

    public NodoDoble<T> getHead() {
        return head;
    }

    public NodoDoble<T> getTail() {
        return tail;
    }
}
