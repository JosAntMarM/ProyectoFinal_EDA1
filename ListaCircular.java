/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class ListaCircular<T> {
    private NodoCircular<T> last;
    private int size;

    public ListaCircular() {
        this.last = null;
        this.size = 0;
    }
    
    public boolean Vacio(){
        return last == null;
    }
    
    public int Tamaño(){
        return size;
    }
    
    public void Agregar(T dato){
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (Vacio()) {
            nuevo.next = nuevo;
            last = nuevo;
        }
        else{
            nuevo.next = last.next;
            last.next = nuevo;
            last = nuevo;
        }
        size++;
    }
    
    public void Imprimir(){
        if (Vacio()) {
            System.out.println("Lista Vacia");
        }
        NodoCircular<T> it = last.next;
        do{
            System.out.println(it.dato.toString());
            it = it.next;
        }while(it != last.next);
    }
    
    public NodoCircular<T> getPrimero(){
        return Vacio() ? null : last.next;
    }
    
}
