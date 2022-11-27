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
public class PesebreraLlenaException extends RuntimeException {
    
    public PesebreraLlenaException(){
    super("Esta pesebrera está llena, elimine algún equino \no gestione otra pesebrera para realizar esta acción");
    }
}
