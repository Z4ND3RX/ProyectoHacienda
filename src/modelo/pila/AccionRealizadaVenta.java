/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.FacturaVenta;

/**
 *
 * @author andre
 */
public class AccionRealizadaVenta {

    public static String actionRegistrar = "Registrar Venta";
    public static String actionEliminar = "Eliminar Venta";

    private FacturaVenta facturaVenta;
    private String action;

    public AccionRealizadaVenta(FacturaVenta facturaVenta, String action) {
        this.facturaVenta = facturaVenta;
        this.action = action;
    }

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
}
