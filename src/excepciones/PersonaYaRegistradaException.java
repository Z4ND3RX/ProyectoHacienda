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
public class PersonaYaRegistradaException extends RuntimeException {

    public PersonaYaRegistradaException() {
        super("Ya se encuentra registrada una persona\ncon el número de documento ingresado");
    }
}
