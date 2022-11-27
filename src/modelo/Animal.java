/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Animal implements Serializable {

    public static final String PORCINO = "Porcino";
    public static final String BOVINO = "Bovino";
    public static final String EQUINO = "Equino";
    public static final String HEMBRA = "Hembra";
    public static final String MACHO = "Macho";
    public static final String UNISEX = "Unisex";
    
    private String nombre;
    private String sexo;
    private int peso;
    private int edad;
    private int codigo;

    public Animal(String sexo, int codigo) {
        this.sexo = sexo;
        this.codigo = codigo;
        this.nombre = "-----";
        this.peso = 0;
        this.edad = 0;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
}
