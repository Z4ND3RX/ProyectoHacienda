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
public class Pesebrera extends Terreno {
    
    public static final int CANTIDADEQUINOSMAXIMA = 2;
    private int cantidadEquinos;
    
    public Pesebrera() {
        cantidadEquinos = 0;
    }
    
    public int getCantidadEquinos() {
        return cantidadEquinos;
    }

    public void setCantidadEquinos(int cantidadEquinos) {
        this.cantidadEquinos = cantidadEquinos;
    }
    
    
}
