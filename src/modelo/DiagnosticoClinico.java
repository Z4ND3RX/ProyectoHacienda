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
public class DiagnosticoClinico implements Serializable {

    public static final String ENFERMEDAD = "Enfermedad";
    public static final String LESION = "Lesión";
    public static final String INTOXICACION = "Intoxicación";

    private int codigoAnimal;
    private String observacion;
    private String tipoObservacion;
    private String fecha;
    private String hora;

    public DiagnosticoClinico(int codigoAnimal, String observacion, String tipoObservacion, String fecha, String hora) {
        this.codigoAnimal = codigoAnimal;
        this.observacion = observacion;
        this.tipoObservacion = tipoObservacion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigoAnimal() {
        return codigoAnimal;
    }

    public void setCodigoAnimal(int codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoObservacion() {
        return tipoObservacion;
    }

    public void setTipoObservacion(String tipoObservacion) {
        this.tipoObservacion = tipoObservacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
