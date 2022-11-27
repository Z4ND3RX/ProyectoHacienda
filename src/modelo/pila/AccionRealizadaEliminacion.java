/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.RazonEliminacion;

/**
 *
 * @author andre
 */
public class AccionRealizadaEliminacion {
    
   public static String actionRegistrar = "Registrar Eliminación";
   public static String actionEliminar = "Eliminar Eliminación";
   
   private RazonEliminacion razon;
   private String action;

    public AccionRealizadaEliminacion(RazonEliminacion razon, String action) {
        this.razon = razon;
        this.action = action;
    }

    public RazonEliminacion getRazon() {
        return razon;
    }

    public void setRazon(RazonEliminacion razon) {
        this.razon = razon;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
   
   
}
