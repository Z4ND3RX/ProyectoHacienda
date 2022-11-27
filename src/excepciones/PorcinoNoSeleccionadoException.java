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
public class PorcinoNoSeleccionadoException extends RuntimeException {

    public PorcinoNoSeleccionadoException() {
        super("Por favor seleccione un porcino de la tabla para poder realizar el proceso");
    }
}
