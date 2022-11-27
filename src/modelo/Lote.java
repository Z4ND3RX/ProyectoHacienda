/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author andre
 */
public class Lote extends Terreno {

    public static final int CANTIDADBOVINOSMAXIMA = 20;
    private int cantidadBovinos;

    public Lote() {
        this.cantidadBovinos = 0;
    }

    public int getCantidadBovinos() {
        return cantidadBovinos;
    }

    public void setCantidadBovinos(int cantidadBovinos) {
        this.cantidadBovinos = cantidadBovinos;
    }
}
