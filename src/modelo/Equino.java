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
public class Equino extends Animal {
    
    private boolean premiado;
    private int numeroPesebrera;
    public static final String INDICATIVO = "EQ";

    public Equino(boolean premiado, int numeroPesebrera, String sexo, int codigo) {
        super(sexo, codigo);
        this.premiado = premiado;
        this.numeroPesebrera = numeroPesebrera;
    }
    
    public boolean isPremiado() {
        return premiado;
    }

    public void setPremiado(boolean premiado) {
        this.premiado = premiado;
    }

    public int getNumeroPesebrera() {
        return numeroPesebrera;
    }

    public void setNumeroPesebrera(int numeroPesebrera) {
        this.numeroPesebrera = numeroPesebrera;
    }
    
    
}
