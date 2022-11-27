/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import modelo.FacturaVenta;
import modelo.RazonEliminacion;
import util.LSE;
import util.Serializadora;

/**
 *
 * @author andre
 */
public class ControladorVYE {

    Serializadora serializadora;
    LSE<RazonEliminacion> listaEliminaciones;
    LSE<FacturaVenta> listaFacturas;

    public ControladorVYE() {
        serializadora = new Serializadora();
        listaEliminaciones = inicializarListaEliminaciones();
        listaFacturas = inicializarListaFacturas();
    }

    private LSE<RazonEliminacion> inicializarListaEliminaciones() {
        LSE<RazonEliminacion> listaEliminacionesx;
        try {
            listaEliminacionesx = serializadora.leerEliminaciones();
            return listaEliminacionesx;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }

    public void escribirListaEliminaciones() {
        try {
            serializadora.escribirEliminaciones(listaEliminaciones);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private LSE<FacturaVenta> inicializarListaFacturas() {
        LSE<FacturaVenta> listaFacturasx;
        try {
            listaFacturasx = serializadora.leerFacturas();
            return listaFacturasx;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }

    public void escribirListaFacturas() {
        try {
            serializadora.escribirFacturas(listaFacturas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void añadirRazonEliminar(RazonEliminacion razon) {
        listaEliminaciones.add(razon);
        escribirListaEliminaciones();
    }

    public void eliminarRazonEliminar(int index) {
        listaEliminaciones.delete(index);
    }

    public int obtenerIndexRazonEliminar(int codigo) {
        for (int i = 0; i < listaEliminaciones.getSize(); i++) {
            if (listaEliminaciones.get(i).getAnimalEliminado().getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public void eliminarFacturaVenta(int index) {
        listaFacturas.delete(index);
    }

    public int obtenerIndexFacturaVenta(int codigo) {
        for (int i = 0; i < listaFacturas.getSize(); i++) {
            if (listaFacturas.get(i).getAnimalVendido().getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public RazonEliminacion getRazon(int index) {
        return listaEliminaciones.get(index);
    }

    public int getSizeRazon() {
        return listaEliminaciones.getSize();
    }

    public void añadirFacturaVenta(FacturaVenta factura) {
        listaFacturas.add(factura);
        escribirListaFacturas();
    }

    public FacturaVenta getFactura(int index) {
        return listaFacturas.get(index);
    }

    public int getSizeFactura() {
        return listaFacturas.getSize();
    }
}
