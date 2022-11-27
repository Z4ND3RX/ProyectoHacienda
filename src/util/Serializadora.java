/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import modelo.Animal;
import modelo.Bovino;
import modelo.CuidadoEquino;
import modelo.DiagnosticoClinico;
import modelo.FacturaVenta;
import modelo.Lote;
import modelo.Pesebrera;
import modelo.Pocilga;
import modelo.Premio;
import modelo.RazonEliminacion;
import modelo.Usuario;

/**
 *
 * @author andre
 */
public class Serializadora {

    private ObjectOutputStream escritorObjetos;
    private ObjectInputStream lectorObjetos;

    public void escribirUsuarios(LSE<Usuario> listaUsuarios) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaUsuarios.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaUsuarios);
    }

    public LSE<Usuario> leerUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<Usuario> listaUsuarios = null;
        FileInputStream file = new FileInputStream("listaUsuarios.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaUsuarios = (LSE<Usuario>) lectorObjetos.readObject();
        return listaUsuarios;
    }

    public void escribirAnimales(LSE<Animal> listaAnimales) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaAnimales.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaAnimales);
    }

    public LSE<Animal> leerAnimales() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<Animal> listaAnimales = null;
        FileInputStream file = new FileInputStream("listaAnimales.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaAnimales = (LSE<Animal>) lectorObjetos.readObject();
        return listaAnimales;
    }

    public void escribirLotes(Lote[][] matrizLotes) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("matrizLotes.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(matrizLotes);
    }

    public Lote[][] leerLotes() throws FileNotFoundException, IOException, ClassNotFoundException {
        Lote[][] matrizLotes = null;
        FileInputStream file = new FileInputStream("matrizLotes.dat");
        lectorObjetos = new ObjectInputStream(file);
        matrizLotes = (Lote[][]) lectorObjetos.readObject();
        return matrizLotes;
    }

    public void escribirPesebreras(Pesebrera[][] matrizPesebreras) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("matrizPesebreras.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(matrizPesebreras);
    }

    public Pesebrera[][] leerPesebreras() throws FileNotFoundException, IOException, ClassNotFoundException {
        Pesebrera[][] matrizPesebreras = null;
        FileInputStream file = new FileInputStream("matrizPesebreras.dat");
        lectorObjetos = new ObjectInputStream(file);
        matrizPesebreras = (Pesebrera[][]) lectorObjetos.readObject();
        return matrizPesebreras;
    }

    public void escribirPocilgas(Pocilga[][] matrizPocilgas) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("matrizPocilgas.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(matrizPocilgas);
    }

    public Pocilga[][] leerPocilgas() throws FileNotFoundException, IOException, ClassNotFoundException {
        Pocilga[][] matrizPocilgas = null;
        FileInputStream file = new FileInputStream("matrizPocilgas.dat");
        lectorObjetos = new ObjectInputStream(file);
        matrizPocilgas = (Pocilga[][]) lectorObjetos.readObject();
        return matrizPocilgas;
    }

    public void escribirPremios(LSE<Premio> listaPremios) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaPremios.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaPremios);
    }

    public LSE<Premio> leerPremios() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<Premio> listaPremios = null;
        FileInputStream file = new FileInputStream("listaPremios.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaPremios = (LSE<Premio>) lectorObjetos.readObject();
        return listaPremios;
    }

    public void escribirCuidados(LSE<CuidadoEquino> listaCuidados) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaCuidados.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaCuidados);
    }

    public LSE<CuidadoEquino> leerCuidados() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<CuidadoEquino> listaCuidados = null;
        FileInputStream file = new FileInputStream("listaCuidados.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaCuidados = (LSE<CuidadoEquino>) lectorObjetos.readObject();
        return listaCuidados;
    }

    public void escribirDiagnosticos(LSE<DiagnosticoClinico> listaDiagnosticos) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaDiagnosticos.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaDiagnosticos);
    }

    public LSE<DiagnosticoClinico> leerDiagnosticos() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<DiagnosticoClinico> listaDiagnosticos = null;
        FileInputStream file = new FileInputStream("listaDiagnosticos.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaDiagnosticos = (LSE<DiagnosticoClinico>) lectorObjetos.readObject();
        return listaDiagnosticos;
    }

    public void escribirEliminaciones(LSE<RazonEliminacion> listaEliminaciones) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaEliminaciones.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaEliminaciones);
    }

    public LSE<RazonEliminacion> leerEliminaciones() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<RazonEliminacion> listaEliminaciones = null;
        FileInputStream file = new FileInputStream("listaEliminaciones.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaEliminaciones = (LSE<RazonEliminacion>) lectorObjetos.readObject();
        return listaEliminaciones;
    }

    public void escribirFacturas(LSE<FacturaVenta> listaFacturas) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaFacturas.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaFacturas);
    }

    public LSE<FacturaVenta> leerFacturas() throws FileNotFoundException, IOException, ClassNotFoundException {
        LSE<FacturaVenta> listaFacturas = null;
        FileInputStream file = new FileInputStream("listaFacturas.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaFacturas = (LSE<FacturaVenta>) lectorObjetos.readObject();
        return listaFacturas;
    }

    public void escribirOrdeño(FIFO<Bovino> listaOrdeño) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaOrdeño.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaOrdeño);
    }

    public FIFO<Bovino> leerOrdeño() throws FileNotFoundException, IOException, ClassNotFoundException {
        FIFO<Bovino> listaOrdeño = null;
        FileInputStream file = new FileInputStream("listaOrdeño.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaOrdeño = (FIFO<Bovino>) lectorObjetos.readObject();
        return listaOrdeño;
    }

    public void escribirAnimalesVeterinario(FIFO<Animal> listaAnimalesVeterinario) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("listaAnimalesVeterinario.dat");
        escritorObjetos = new ObjectOutputStream(file);
        escritorObjetos.writeObject(listaAnimalesVeterinario);
    }

    public FIFO<Animal> leerAnimalesVeterinario() throws FileNotFoundException, IOException, ClassNotFoundException {
        FIFO<Animal> listaAnimalesVeterinario = null;
        FileInputStream file = new FileInputStream("listaAnimalesVeterinario.dat");
        lectorObjetos = new ObjectInputStream(file);
        listaAnimalesVeterinario = (FIFO<Animal>) lectorObjetos.readObject();
        return listaAnimalesVeterinario;
    }
}
