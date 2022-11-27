/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Nodo<Z> implements Serializable {
    
    private Z dato;
    private Nodo<Z> nodoSiguiente;

    public Nodo(Z dato) {
        this.dato = dato;
        this.nodoSiguiente = null;
    }

    Nodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Z getDato() {
        return dato;
    }

    public void setDato(Z dato) {
        this.dato = dato;
    }

    public Nodo<Z> getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Nodo<Z> nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

}
