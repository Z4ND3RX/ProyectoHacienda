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
public class RazonEliminacion implements Serializable {
    
    private Animal animalEliminado;
    private String razon;

    public RazonEliminacion(Animal animalEliminado, String razon) {
        this.animalEliminado = animalEliminado;
        this.razon = razon;
    }

    public Animal getAnimalEliminado() {
        return animalEliminado;
    }

    public void setAnimalEliminado(Animal animalEliminado) {
        this.animalEliminado = animalEliminado;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    
}
