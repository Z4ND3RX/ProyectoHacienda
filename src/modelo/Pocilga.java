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
public class Pocilga extends Terreno {

    private boolean crias;
    public static final int CANTIDADPORCINOSMAXIMA = 4;
    private int cantidadPorcinos;

    public Pocilga() {
        this.crias = false;
        this.cantidadPorcinos = 0;
    }

    public boolean isCrias() {
        return crias;
    }

    public void setCrias(boolean crias) {
        this.crias = crias;
    }

    public int getCantidadPorcinos() {
        return cantidadPorcinos;
    }

    public void setCantidadPorcinos(int cantidadPorcinos) {
        this.cantidadPorcinos = cantidadPorcinos;
    }

}
