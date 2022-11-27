/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import modelo.CuidadoEquino;
import modelo.Premio;
import util.LSE;
import util.Serializadora;

/**
 *
 * @author andre
 */
public class ControladorDPC {

    Serializadora serializadora;
    LSE<Premio> listaPremios;
    LSE<CuidadoEquino> listaCuidados;

    public ControladorDPC() {
        serializadora = new Serializadora();
        listaPremios = inicializarListaPremios();
        listaCuidados = inicializarListaCuidados();
    }

    private LSE<Premio> inicializarListaPremios() {
        LSE<Premio> listaPremios;
        try {
            listaPremios = serializadora.leerPremios();
            return listaPremios;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }

    public void escribirPremios() {
        try {
            serializadora.escribirPremios(listaPremios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private LSE<CuidadoEquino> inicializarListaCuidados() {
        LSE<CuidadoEquino> listaCuidados;
        try {
            listaCuidados = serializadora.leerCuidados();
            return listaCuidados;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }
    
    public void escribirCuidados() {
        try {
            serializadora.escribirCuidados(listaCuidados);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void añadirPremio(Premio premio) {
        listaPremios.add(premio);
        escribirPremios();
    }

    public void añadirCuidado(CuidadoEquino cuidado) {
        listaCuidados.add(cuidado);
        escribirCuidados();
    }

    public Premio getPremio(int index) {
        return listaPremios.get(index);
    }

    public CuidadoEquino getCuidado(int index) {
        return listaCuidados.get(index);
    }

    public void eliminarPremio(int index) {
        listaPremios.delete(index);
        escribirPremios();
    }

    public void eliminarCuidado(int index) {
        listaCuidados.delete(index);
        escribirCuidados();
    }

    public int getSizePremios() {
        return listaPremios.getSize();
    }

    public int getSizeCuidados() {
        return listaCuidados.getSize();
    }

}
