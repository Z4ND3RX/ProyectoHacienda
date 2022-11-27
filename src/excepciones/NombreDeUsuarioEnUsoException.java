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
public class NombreDeUsuarioEnUsoException extends RuntimeException {

    public NombreDeUsuarioEnUsoException() {
        super("El nombre de usuario ingresado ya se encuentra en uso");
    }
}
