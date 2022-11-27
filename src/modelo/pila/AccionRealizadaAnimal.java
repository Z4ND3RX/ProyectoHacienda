/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.Animal;

/**
 *
 * @author andre
 */
public class AccionRealizadaAnimal {

    public static String actionRegistrar = "Registrar";
    public static String actionEliminar = "Eliminar";
    public static String actionEditar = "Editar";
    public static String actionOrdeño = "Ordeño";
    public static String actionRealizarDiagnostico = "Realizar Diagnóstico";
    public static String actionDesrealizarDiagnostico = "Desrealizar Diagnóstico";

    private Animal animal;
    private String action;
    private int fila;
    private int columna;

    public AccionRealizadaAnimal(Animal animal, String action, int fila, int columna) {
        this.animal = animal;
        this.action = action;
        this.fila = fila;
        this.columna = columna;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

}
