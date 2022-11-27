/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pila;

import modelo.DiagnosticoClinico;

/**
 *
 * @author andre
 */
public class AccionRealizadaDiagnostico {

    public static String actionRegistrar = "Registrar Diagnóstico";
    public static String actionEliminar = "Eliminar Diagnóstico";

    private DiagnosticoClinico diagnostico;
    private String action;

    public AccionRealizadaDiagnostico(DiagnosticoClinico diagnostico, String action) {
        this.diagnostico = diagnostico;
        this.action = action;
    }

    public DiagnosticoClinico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoClinico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
