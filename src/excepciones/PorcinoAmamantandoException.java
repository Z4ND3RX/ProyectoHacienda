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
public class PorcinoAmamantandoException extends RuntimeException {
    
    public PorcinoAmamantandoException(){
    super("El porcino se encuentra amamantando (Crías), por ende,\nno se puede eliminar ni vender");
    }
}
