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
public class DatosErroneosException extends RuntimeException{
    
    public DatosErroneosException(){
    super("Los datos ingresados son Erróneos,\nintente nuevamente.");
    }
}
