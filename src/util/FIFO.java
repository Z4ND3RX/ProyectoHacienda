/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import excepciones.ColaVaciaException;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class FIFO<W> implements Serializable {

    private Nodo<W> primero;
    private int size;

    public FIFO() {
        this.primero = null;
        size = 0;
    }

    public void encolar(W dato) {
        Nodo<W> nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<W> auxiliar = primero;
            while (auxiliar.getNodoSiguiente() != null) {
                auxiliar = auxiliar.getNodoSiguiente();
            }
            auxiliar.setNodoSiguiente(nuevo);
        }
        size++;
    }

    public void encolarPrimeraPosición(W dato) {
        Nodo<W> nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<W> auxiliar = primero;
            nuevo.setNodoSiguiente(auxiliar);
            primero = nuevo;
        }
        size++;
    }

    public W desencolar() throws ColaVaciaException {
        isEmpty();
        Nodo<W> auxiliar = primero;
        primero = primero.getNodoSiguiente();
        size--;
        return auxiliar.getDato();
    }

    public W frente() throws ColaVaciaException {
        isEmpty();
        return primero.getDato();
    }

    public void isEmpty() throws ColaVaciaException {
        if (primero == null) {
            throw new ColaVaciaException();
        }
    }

    public W get(int index) {
        if (index < size && index >= 0) {
            Nodo<W> auxiliar = null;
            if (index == 0) {
                return primero.getDato();
            } else {
                auxiliar = primero;
                int contador = 0;
                while (contador < index) {
                    auxiliar = auxiliar.getNodoSiguiente();
                    contador++;
                }
            }
            return auxiliar.getDato();
        } else {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    public int getSize() {
        return size;
    }
}
