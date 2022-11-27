/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author andre
 */
public class LIFO<T> {

    private Nodo<T> primero;
    private int size;

    public LIFO() {
        primero = null;
        size = 0;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        Nodo<T> auxiliar = primero;
        nuevo.setNodoSiguiente(auxiliar);
        primero = nuevo;
        size++;
    }

    public T pop() {
        Nodo<T> auxiliar = primero;
        primero = primero.getNodoSiguiente();
        size--;
        return auxiliar.getDato();
    }

    public void reset() {
        primero = null;
    }

    public boolean isEmpty() {
        if (primero == null) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}
