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
public class PocilgaLlenaException extends RuntimeException {
    
    public PocilgaLlenaException(){
    super("Esta pocilga está llena, elimine algún porcino \no gestione otra pocilga para realizar esta acción");
    }
}
