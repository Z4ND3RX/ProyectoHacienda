/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import excepciones.CitaPendienteVeterinario;
import excepciones.ColaVaciaException;
import excepciones.PorcinoNoLiberadoException;
import excepciones.LoteLlenoException;
import excepciones.PesebreraLlenaException;
import excepciones.PocilgaLlenaException;
import excepciones.PocilgaSoloParaCriasException;
import excepciones.PorcinoAmamantandoException;
import java.io.IOException;
import modelo.Animal;
import modelo.Bovino;
import modelo.Equino;
import modelo.Lote;
import modelo.Pesebrera;
import modelo.Pocilga;
import modelo.Porcino;
import modelo.Terreno;
import util.FIFO;
import util.LSE;
import util.Serializadora;

/**
 *
 * @author andre
 */
public class ControladorTerreno {

    Serializadora serializadora;

    Lote[][] lotes;
    Pesebrera[][] pesebreras;
    Pocilga[][] pocilgas;

    LSE<Animal> listaAnimal;
    FIFO<Bovino> listaOrdeño;

    boolean estanciaLotes = true;
    boolean estanciaPesebreras = true;
    boolean estanciaPocilgas = true;

    public ControladorTerreno() {
        serializadora = new Serializadora();
        lotes = inicializarMatrizLotes();
        if (estanciaLotes == false) {
            initLotes();
        }
        pesebreras = inicializarMatrizPesebreras();
        if (estanciaPesebreras == false) {
            initPesebreras();
        }
        pocilgas = inicializarMatrizPocilgas();
        if (estanciaPocilgas == false) {
            initPocilgas();
        }
        listaAnimal = inicializarListaAnimales();
        listaOrdeño = inicializarListaOrdeño();
    }

    private LSE<Animal> inicializarListaAnimales() {
        LSE<Animal> listaAnimales;
        try {
            listaAnimales = serializadora.leerAnimales();
            return listaAnimales;
        } catch (IOException | ClassNotFoundException ex) {
            return new LSE<>();
        }
    }

    public void escribirAnimales() {
        try {
            serializadora.escribirAnimales(listaAnimal);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private FIFO<Bovino> inicializarListaOrdeño() {
        FIFO<Bovino> listaOrdeñar;
        try {
            listaOrdeñar = serializadora.leerOrdeño();
            return listaOrdeñar;
        } catch (IOException | ClassNotFoundException ex) {
            return new FIFO<>();
        }
    }

    public void escribirOrdeño() {
        try {
            serializadora.escribirOrdeño(listaOrdeño);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Lote[][] inicializarMatrizLotes() {
        Lote[][] matrizLotes;
        try {
            matrizLotes = serializadora.leerLotes();
            return matrizLotes;
        } catch (IOException | ClassNotFoundException ex) {
            estanciaLotes = false;
            return new Lote[3][4];
        }
    }

    public void escribirLotes() {
        try {
            serializadora.escribirLotes(lotes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Pesebrera[][] inicializarMatrizPesebreras() {
        Pesebrera[][] matrizPesebreras;
        try {
            matrizPesebreras = serializadora.leerPesebreras();
            return matrizPesebreras;
        } catch (IOException | ClassNotFoundException ex) {
            estanciaPesebreras = false;
            return new Pesebrera[4][6];
        }
    }

    public void escribirPesebreras() {
        try {
            serializadora.escribirPesebreras(pesebreras);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Pocilga[][] inicializarMatrizPocilgas() {
        Pocilga[][] matrizPocilgas;
        try {
            matrizPocilgas = serializadora.leerPocilgas();
            return matrizPocilgas;
        } catch (IOException | ClassNotFoundException ex) {
            estanciaPocilgas = false;
            return new Pocilga[2][8];
        }
    }

    public void escribirPocilgas() {
        try {
            serializadora.escribirPocilgas(pocilgas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initLotes() {
        int contador = 1;
        for (int i = 0; i < lotes.length; i++) {
            for (int j = 0; j < lotes[i].length; j++) {
                lotes[i][j] = new Lote();
                lotes[i][j].setNumero(contador);
                contador++;
            }
        }
        escribirLotes();
    }

    public void initPesebreras() {
        int contador = 1;
        for (int i = 0; i < pesebreras.length; i++) {
            for (int j = 0; j < pesebreras[i].length; j++) {
                pesebreras[i][j] = new Pesebrera();
                pesebreras[i][j].setNumero(contador);
                contador++;
            }
        }
        escribirPesebreras();
    }

    public void initPocilgas() {
        int contador = 1;
        for (int i = 0; i < pocilgas.length; i++) {
            for (int j = 0; j < pocilgas[i].length; j++) {
                pocilgas[i][j] = new Pocilga();
                pocilgas[i][j].setNumero(contador);
                contador++;
            }
        }
        escribirPocilgas();
    }

    public Lote obtenerLote(int fila, int columna) {
        return lotes[fila][columna];
    }

    public Pesebrera obtenerPesebrera(int fila, int columna) {
        return pesebreras[fila][columna];
    }

    public Pocilga obtenerPocilga(int fila, int columna) {
        return pocilgas[fila][columna];
    }

    public void habilitarCrias(int fila, int columna) {
        pocilgas[fila][columna].setCrias(true);
        escribirPocilgas();
    }

    public void deshabilitarCrias(int fila, int columna) {
        pocilgas[fila][columna].setCrias(false);
        escribirPocilgas();
    }

    public void liberarPorcino(int fila, int columna, int index, String sexo) throws PorcinoNoLiberadoException {
        int contador = 1;
        for (int i = 0; i < pocilgas.length; i++) {
            for (int j = 0; j < pocilgas[i].length; j++) {
                if (pocilgas[i][j].getCantidadPorcinos() < Pocilga.CANTIDADPORCINOSMAXIMA && pocilgas[i][j].isCrias() == false) {
                    Porcino porcino = (Porcino) listaAnimal.get(index);
                    porcino.setSexo(sexo);
                    porcino.setNumeroPocilga(contador);
                    listaAnimal.edit(index, porcino);
                    aumentarCantidadAnimales(i, j, "Pocilga");
                    if (pocilgas[i][j].getEstado().equals(Pocilga.VACIO)) {
                        cambiarEstadoTerreno(i, j, 3, "Pocilga");
                        asignarSexoTerreno(i, j, 3, "Pocilga");
                    }
                    disminuirCantidadAnimales(fila, columna, "Pocilga");
                    escribirAnimales();
                    return;
                }
                contador++;
            }
        }
        throw new PorcinoNoLiberadoException();
    }

    public void cambiarEstadoTerreno(int fila, int columna, int estado, String terreno) {
        // 1 vacio, 2 Lleno, 3 Ocupando.
        switch (estado) {
            case 1:
                switch (terreno) {
                    case "Lote":
                        lotes[fila][columna].setEstado(Lote.VACIO);
                        break;
                    case "Pesebrera":
                        pesebreras[fila][columna].setEstado(Pesebrera.VACIO);
                        break;
                    default:
                        pocilgas[fila][columna].setEstado(Pocilga.VACIO);
                        break;
                }
                break;
            case 2:
                switch (terreno) {
                    case "Lote":
                        lotes[fila][columna].setEstado(Lote.LLENO);
                        break;
                    case "Pesebrera":
                        pesebreras[fila][columna].setEstado(Pesebrera.LLENO);
                        break;
                    default:
                        pocilgas[fila][columna].setEstado(Pocilga.LLENO);
                        break;
                }
                break;
            case 3:
                switch (terreno) {
                    case "Lote":
                        lotes[fila][columna].setEstado(Lote.OCUPANDO);
                        break;
                    case "Pesebrera":
                        pesebreras[fila][columna].setEstado(Pesebrera.OCUPANDO);
                        break;
                    default:
                        pocilgas[fila][columna].setEstado(Pocilga.OCUPANDO);
                        break;
                }
                break;
        }
        escribirLotes();
        escribirPesebreras();
        escribirPocilgas();
    }

    public void asignarSexoTerreno(int fila, int columna, int sexoAnimales, String terreno) {
        //1 hembra, 2 macho, 3 unisex
        switch (sexoAnimales) {
            case 1:
                switch (terreno) {
                    case "Lote":
                        lotes[fila][columna].setSexoAnimales(Lote.HEMBRA);
                        break;
                    case "Pesebrera":
                        pesebreras[fila][columna].setSexoAnimales(Pesebrera.HEMBRA);
                        break;
                    default:
                        pocilgas[fila][columna].setSexoAnimales(Pocilga.HEMBRA);
                        break;
                }
                break;
            case 2:
                switch (terreno) {
                    case "Lote":
                        lotes[fila][columna].setSexoAnimales(Lote.MACHO);
                        break;
                    case "Pesebrera":
                        pesebreras[fila][columna].setSexoAnimales(Pesebrera.MACHO);
                        break;
                    default:
                        pocilgas[fila][columna].setSexoAnimales(Pocilga.MACHO);
                        break;
                }
                break;
            case 3:
                pocilgas[fila][columna].setSexoAnimales(Animal.UNISEX);
                break;
        }
        escribirLotes();
        escribirPesebreras();
        escribirPocilgas();
    }

    public void aumentarCantidadAnimales(int fila, int columna, String terreno) {
        int cantidad;
        switch (terreno) {
            case "Lote":
                cantidad = lotes[fila][columna].getCantidadBovinos() + 1;
                lotes[fila][columna].setCantidadBovinos(cantidad);
                escribirLotes();
                break;
            case "Pesebrera":
                cantidad = pesebreras[fila][columna].getCantidadEquinos() + 1;
                pesebreras[fila][columna].setCantidadEquinos(cantidad);
                escribirPesebreras();
                break;
            default:
                cantidad = pocilgas[fila][columna].getCantidadPorcinos() + 1;
                pocilgas[fila][columna].setCantidadPorcinos(cantidad);
                escribirPocilgas();
                break;
        }
    }

    public void disminuirCantidadAnimales(int fila, int columna, String terreno) {
        int cantidad;
        switch (terreno) {
            case "Lote":
                cantidad = lotes[fila][columna].getCantidadBovinos() - 1;
                lotes[fila][columna].setCantidadBovinos(cantidad);
                escribirLotes();
                break;
            case "Pesebrera":
                cantidad = pesebreras[fila][columna].getCantidadEquinos() - 1;
                pesebreras[fila][columna].setCantidadEquinos(cantidad);
                escribirPesebreras();
                break;
            default:
                cantidad = pocilgas[fila][columna].getCantidadPorcinos() - 1;
                pocilgas[fila][columna].setCantidadPorcinos(cantidad);
                escribirPocilgas();
                break;
        }
    }

    public void validarCantidadAnimales(int fila, int columna, String terreno) throws LoteLlenoException, PesebreraLlenaException, PocilgaLlenaException {
        int cantidad;
        switch (terreno) {
            case "Lote":
                cantidad = lotes[fila][columna].getCantidadBovinos();
                if (cantidad >= Lote.CANTIDADBOVINOSMAXIMA) {
                    throw new LoteLlenoException();
                }
                break;
            case "Pesebrera":
                cantidad = pesebreras[fila][columna].getCantidadEquinos();
                if (cantidad >= Pesebrera.CANTIDADEQUINOSMAXIMA) {
                    throw new PesebreraLlenaException();
                }
                break;
            default:
                cantidad = pocilgas[fila][columna].getCantidadPorcinos();
                if (cantidad >= Pocilga.CANTIDADPORCINOSMAXIMA) {
                    throw new PocilgaLlenaException();
                }
                break;
        }
    }

    public boolean validarCodigoAnimal(int codigo) {
        if (getSize() > 0) {
            for (int i = 0; i < getSize(); i++) {
                if (codigo == getAnimal(i).getCodigo()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void añadirAnimal(int fila, int columna, String terreno, Animal animal, boolean cria) throws PocilgaSoloParaCriasException, LoteLlenoException, PesebreraLlenaException, PocilgaLlenaException {
        if (cria == false) {
            validarCantidadAnimales(fila, columna, terreno);
        }
        boolean validation = validarCodigoAnimal(animal.getCodigo());
        int codigo = animal.getCodigo();
        while (validation == false) {
            codigo++;
            validation = validarCodigoAnimal(codigo);
        }
        animal.setCodigo(codigo);
        listaAnimal.add(animal);
        aumentarCantidadAnimales(fila, columna, terreno);
        escribirAnimales();
    }

    public Animal getAnimal(int index) {
        return listaAnimal.get(index);
    }

    public int getIndexAnimalCodigo(int codigo) {
        for (int i = 0; i < listaAnimal.getSize(); i++) {
            if (listaAnimal.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public void eliminarAnimal(int fila, int columna, String terreno, int index) throws PorcinoAmamantandoException {
        Animal animal = getAnimal(index);
        if (animal instanceof Porcino) {
            Porcino porcino = (Porcino) animal;
            if (porcino.isAmamanta()) {
                throw new PorcinoAmamantandoException();
            }
            listaAnimal.delete(index);
            disminuirCantidadAnimales(fila, columna, terreno);
        } else {
            listaAnimal.delete(index);
            disminuirCantidadAnimales(fila, columna, terreno);
        }
        escribirAnimales();
    }

    public void editarAnimal(int index, Animal animal) {
        listaAnimal.edit(index, animal);
        escribirAnimales();
    }

    public int getSize() {
        return listaAnimal.getSize();
    }

    public void encolar(Bovino dato) {
        listaOrdeño.encolar(dato);
        escribirOrdeño();
    }

    public Bovino desencolar() throws ColaVaciaException {
        return listaOrdeño.desencolar();
    }

    public Bovino frente() throws ColaVaciaException {
        escribirOrdeño();
        return listaOrdeño.frente();
    }

    public int getSizeOrdeño() {
        return listaOrdeño.getSize();
    }

}
