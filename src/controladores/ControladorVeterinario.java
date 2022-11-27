/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import excepciones.CitaPendienteVeterinario;
import excepciones.ColaVaciaException;
import java.io.IOException;
import modelo.Animal;
import modelo.DiagnosticoClinico;
import util.FIFO;
import util.LSE;
import util.Serializadora;

/**
 *
 * @author andre
 */
public class ControladorVeterinario {

    Serializadora serializadora;
    FIFO<Animal> listaAnimales;
    LSE<DiagnosticoClinico> listaDiagnosticos;

    public ControladorVeterinario() {
        serializadora = new Serializadora();
        listaAnimales = inicializarListaAnimales();
        listaDiagnosticos = inicializarListaDiagnosticos();
    }

    private LSE<DiagnosticoClinico> inicializarListaDiagnosticos() {
        LSE<DiagnosticoClinico> listaDiagnosticos;
        try {
            listaDiagnosticos = serializadora.leerDiagnosticos();
            return listaDiagnosticos;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }

    public void escribirDiagnosticos() {
        try {
            serializadora.escribirDiagnosticos(listaDiagnosticos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private FIFO<Animal> inicializarListaAnimales() {
        FIFO<Animal> listaAnimalesVeterinario;
        try {
            listaAnimalesVeterinario = serializadora.leerAnimalesVeterinario();
            return listaAnimalesVeterinario;
        } catch (IOException | ClassNotFoundException ex) {
            return new FIFO<>();
        }
    }

    public void escribirListaAnimales() {
        try {
            serializadora.escribirAnimalesVeterinario(listaAnimales);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void añadirDiagnostico(DiagnosticoClinico diagnosticoClinico) {
        listaDiagnosticos.add(diagnosticoClinico);
        escribirDiagnosticos();
    }

    public DiagnosticoClinico obtenerDiagnostico(int index) {
        return listaDiagnosticos.get(index);
    }

    public void eliminarDiagnostico(int index) {
        listaDiagnosticos.delete(index);
        escribirDiagnosticos();
    }

    public int getSizeDiagnosticos() {
        return listaDiagnosticos.getSize();
    }

    public void validarEstancia(int codigo) throws CitaPendienteVeterinario {
        if (listaAnimales.getSize() > 0) {
            for (int i = 0; i < listaAnimales.getSize(); i++) {
                if (codigo == listaAnimales.get(i).getCodigo()) {
                    throw new CitaPendienteVeterinario();
                }
            }
        }
    }

    public void encolar(Animal dato) throws CitaPendienteVeterinario {
        validarEstancia(dato.getCodigo());
        listaAnimales.encolar(dato);
        escribirListaAnimales();
    }

    public void encolarPrimeraPosicion(Animal dato) {
        listaAnimales.encolarPrimeraPosición(dato);
        escribirListaAnimales();
    }

    public Animal desencolar() throws ColaVaciaException {
        return listaAnimales.desencolar();
    }

    public Animal frente() throws ColaVaciaException {
        escribirListaAnimales();
        return listaAnimales.frente();
    }
}
