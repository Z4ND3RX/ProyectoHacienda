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
public class EquinoNoSeleccionadoException extends RuntimeException {

    public EquinoNoSeleccionadoException() {
        super("Por favor seleccione un equino de la tabla para poder realizar el proceso");
    }
}
