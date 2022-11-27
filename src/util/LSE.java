/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.Serializable;
import modelo.Usuario;

/**
 *
 * @author andre
 */
public class LSE<W> implements Serializable{

    private Nodo<W> primero;
    private int size;

    public LSE() {
        primero = null;
        size = 0;
    }

    public void add(W dato) {
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

    public void delete(int index) {
        Nodo<W> auxiliar = primero;
        Nodo<W> eliminar;
        if (index == 0) {
            primero = auxiliar.getNodoSiguiente();
        }
        if (index > 0 && index < size) {
            int contador = 0;
            while (contador < index - 1) {
                auxiliar = auxiliar.getNodoSiguiente();
                contador++;
            }
            eliminar = auxiliar.getNodoSiguiente();
            auxiliar.setNodoSiguiente(eliminar.getNodoSiguiente());
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index);
        }
        size--;
    }

    public void edit(int index, W dato) {
        Nodo<W> auxiliar = primero;
        if (index < size && index >= 0) {
            if (index == 0) {
                primero.setDato(dato);
            } else if (index > 0 && index < size) {
                int contador = 0;
                while (contador < index) {
                    auxiliar = auxiliar.getNodoSiguiente();
                    contador++;
                }
                auxiliar.setDato(dato);
            }
        } else {
            throw new IndexOutOfBoundsException("Index " + index);
        }
    }

    public int getSize() {
        return size;
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
}
