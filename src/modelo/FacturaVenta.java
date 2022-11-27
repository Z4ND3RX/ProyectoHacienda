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
public class FacturaVenta implements Serializable {

    private Persona comprador;
    private Animal animalVendido;
    private double valor;

    public FacturaVenta(Persona comprador, Animal animalVendido, double valor) {
        this.comprador = comprador;
        this.animalVendido = animalVendido;
        this.valor = valor;
    }

    public Persona getComprador() {
        return comprador;
    }

    public void setComprador(Persona comprador) {
        this.comprador = comprador;
    }

    public Animal getAnimalVendido() {
        return animalVendido;
    }

    public void setAnimalVendido(Animal animalVendido) {
        this.animalVendido = animalVendido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
