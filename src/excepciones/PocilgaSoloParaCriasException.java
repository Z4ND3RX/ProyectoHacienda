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
public class PocilgaSoloParaCriasException extends RuntimeException {
    
    public PocilgaSoloParaCriasException(){
    super("Esta pocilga es exclusivamente para la porcino y sus crías.\nsi desea cambiar esto... libere las crías");
    }
    
}
