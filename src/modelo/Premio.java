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
public class Premio implements Serializable {

    private int codigoEquino;
    private String tipo;
    private String titulo;
    private String year;

    public Premio(int codigoEquino, String tipo, String titulo, String year) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.year = year;
        this.codigoEquino = codigoEquino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCodigoEquino() {
        return codigoEquino;
    }

    public void setCodigoEquino(int codigoEquino) {
        this.codigoEquino = codigoEquino;
    }

}
