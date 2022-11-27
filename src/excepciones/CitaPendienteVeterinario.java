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
public class CitaPendienteVeterinario extends RuntimeException {

    public CitaPendienteVeterinario() {
        super("El animal ya tiene una cita pendiente con el veteriario");
    }
}
