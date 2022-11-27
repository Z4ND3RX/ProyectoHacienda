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
public class CuidadoEquino implements Serializable {

    private int codigoEquino;
    private String CuidadoRealizado;
    private String year;

    public CuidadoEquino(int codigoEquino, String CuidadoRealizado, String year) {
        this.codigoEquino = codigoEquino;
        this.CuidadoRealizado = CuidadoRealizado;
        this.year = year;
    }

    public int getCodigoEquino() {
        return codigoEquino;
    }

    public void setCodigoEquino(int codigoEquino) {
        this.codigoEquino = codigoEquino;
    }

    public String getCuidadoRealizado() {
        return CuidadoRealizado;
    }

    public void setCuidadoRealizado(String CuidadoRealizado) {
        this.CuidadoRealizado = CuidadoRealizado;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
