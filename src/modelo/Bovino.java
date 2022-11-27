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
public class Bovino extends Animal {

    public static final String INDICATIVO = "BO";
    private int litrosLecheProducida;
    private int litrosLecheTotalProducida;
    private int numeroLote;

    public Bovino(String sexo, int codigo, int numeroLote) {
        super(sexo, codigo);
        this.litrosLecheProducida = 0;
        this.numeroLote = numeroLote;
        this.litrosLecheTotalProducida = 0;
    }

    public int getLitrosLecheProducida() {
        return litrosLecheProducida;
    }

    public void setLitrosLecheProducida(int litrosLecheProducida) {
        this.litrosLecheProducida = litrosLecheProducida;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public int getLitrosLecheTotalProducida() {
        return litrosLecheTotalProducida;
    }

    public void setLitrosLecheTotalProducida(int litrosLecheTotalProducida) {
        this.litrosLecheTotalProducida = litrosLecheTotalProducida;
    }

    
}
