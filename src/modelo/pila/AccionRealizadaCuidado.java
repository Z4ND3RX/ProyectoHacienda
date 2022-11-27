/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.CuidadoEquino;

/**
 *
 * @author andre
 */
public class AccionRealizadaCuidado {

    public static String actionRegistrar = "Registrar Cuidado";
    public static String actionEliminar = "Eliminar Cuidado";

    private CuidadoEquino cuidado;
    private String accion;

    public AccionRealizadaCuidado(CuidadoEquino cuidado, String accion) {
        this.cuidado = cuidado;
        this.accion = accion;
    }

    public CuidadoEquino getCuidado() {
        return cuidado;
    }

    public void setCuidado(CuidadoEquino cuidado) {
        this.cuidado = cuidado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
