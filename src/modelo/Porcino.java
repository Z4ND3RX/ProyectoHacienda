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
public class Porcino extends Animal {

    public static final String CRIA = "Cría";
    private boolean amamanta;
    private int numeroPocilga;
    public static final String INDICATIVO = "PO";

    public Porcino(boolean amamanta, int numeroPocilga, String sexo, int codigo) {
        super(sexo, codigo);
        this.amamanta = amamanta;
        this.numeroPocilga = numeroPocilga;
    }

    public boolean isAmamanta() {
        return amamanta;
    }

    public void setAmamanta(boolean amamanta) {
        this.amamanta = amamanta;
    }

    public int getNumeroPocilga() {
        return numeroPocilga;
    }

    public void setNumeroPocilga(int numeroPocilga) {
        this.numeroPocilga = numeroPocilga;
    }

    
}
