/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author andre
 */
public class RazonNoSeleccionadaException extends RuntimeException {

    public RazonNoSeleccionadaException() {
        super("Por favor seleccione una opción válida");
    }
}
