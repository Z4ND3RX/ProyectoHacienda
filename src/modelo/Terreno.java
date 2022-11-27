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
public class Terreno implements Serializable {

    public static final String VACIO = "Vacío";
    public static final String LLENO = "Lleno";
    public static final String OCUPANDO = "Ocupando";
    public static final String HEMBRA = "Hembra";
    public static final String MACHO = "Macho";
    public static double valorxKilo = 14000;

    private int numero;
    private String estado;
    private String sexoAnimales;

    public Terreno() {
        this.numero = 0;
        this.estado = VACIO;
        this.sexoAnimales = null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSexoAnimales() {
        return sexoAnimales;
    }

    public void setSexoAnimales(String sexoAnimales) {
        this.sexoAnimales = sexoAnimales;
    }

    public static double getValorxKilo() {
        return valorxKilo;
    }

    public static void setValorxKilo(double valorxKilo) {
        Terreno.valorxKilo = valorxKilo;
    }

}
