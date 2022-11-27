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
public class LoteLlenoException extends RuntimeException {

    public LoteLlenoException() {
        super("Este lote está lleno, elimine algún bovino \no gestione otro lote para realizar esta acción");
    }
}
