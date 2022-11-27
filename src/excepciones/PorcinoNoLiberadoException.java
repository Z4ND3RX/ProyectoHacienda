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
public class PorcinoNoLiberadoException extends RuntimeException {
    
    public PorcinoNoLiberadoException(){
    super("No se ha podido realizar la operación /ndado que todas las pocilgas están llenas");
    }
}
