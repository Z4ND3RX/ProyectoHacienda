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
public class DocumentoNoEncontradoException extends RuntimeException {
    
    public DocumentoNoEncontradoException(){
    super("El documento ingresado no se encuentra registrado en el sistema");
    }
}
