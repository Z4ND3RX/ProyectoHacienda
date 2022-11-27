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
public class PesoNoValidoException extends RuntimeException {

    public PesoNoValidoException() {
        super("Peso del animal no válido, modifiquelo e intente de nuevo");
    }
}
