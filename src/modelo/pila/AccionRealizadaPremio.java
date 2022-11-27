/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.Premio;

/**
 *
 * @author andre
 */
public class AccionRealizadaPremio {

    public static String actionRegistrar = "Registrar Premio";
    public static String actionEliminar = "Eliminar Premio";

    private Premio premio;
    private String action;

    public AccionRealizadaPremio(Premio premio, String action) {
        this.premio = premio;
        this.action = action;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
