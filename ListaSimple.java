/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class ListaSimple<T>{
    private Nodo<T> head;
    private int size;

    public ListaSimple() {
        this.head = null;
        this.size = 0;
    }
    
    public int tamaño(){
        return size;
    }
    
    public boolean Vacio(){
        return size == 0;
    }
            
    public void Agregar(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if (head == null) {
            head = nuevo;
        }
        else{
            Nodo<T> it = head;
            while(it.next != null){
                it = it.next;
            }
            it.next = nuevo;
        }
        size++;
    }
    
    public T Obtener(int indice){
        if (indice < 0 || indice >= size) {
            return null;
        }
        Nodo<T> it = head;
        for (int i = 0; i < indice; i++) {
            it = it.next;
        }
        return it.dato;
    }
    
    public void Imprimir(){
        Nodo<T> it = head;
        while(it != null){
            System.out.println(it.dato.toString());
            it = it.next;
        }
    }
}