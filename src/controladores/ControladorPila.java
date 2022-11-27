/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.Animal;
import modelo.DiagnosticoClinico;
import modelo.pila.AccionRealizadaAnimal;
import modelo.pila.AccionRealizadaCuidado;
import modelo.pila.AccionRealizadaDiagnostico;
import modelo.pila.AccionRealizadaEliminacion;
import modelo.pila.AccionRealizadaPremio;
import modelo.pila.AccionRealizadaVenta;
import util.LIFO;

/**
 *
 * @author andre
 */
public class ControladorPila {

    LIFO<AccionRealizadaAnimal> pilaAnimales;
    LIFO<AccionRealizadaAnimal> pilaAnimalesDos;
    LIFO<AccionRealizadaDiagnostico> pilaHistorialGestion;
    LIFO<AccionRealizadaDiagnostico> pilaHistorial;
    LIFO<AccionRealizadaDiagnostico> pilaHistorialDos;
    LIFO<AccionRealizadaEliminacion> pilaEliminaciones;
    LIFO<AccionRealizadaPremio> pilaPremios;
    LIFO<AccionRealizadaPremio> pilaPremiosDos;
    LIFO<AccionRealizadaPremio> pilaPremiosGestion;
    LIFO<AccionRealizadaCuidado> pilaCuidados;
    LIFO<AccionRealizadaCuidado> pilaCuidadosDos;
    LIFO<AccionRealizadaCuidado> pilaCuidadosGestion;
    LIFO<AccionRealizadaVenta> pilaVentas;

    public ControladorPila() {
        pilaAnimales = new LIFO<>();
        pilaAnimalesDos = new LIFO<>();
        pilaHistorialGestion = new LIFO<>();
        pilaHistorial = new LIFO<>();
        pilaHistorialDos = new LIFO<>();
        pilaEliminaciones = new LIFO<>();
        pilaVentas = new LIFO<>();
        pilaPremios = new LIFO<>();
        pilaPremiosDos = new LIFO<>();
        pilaPremiosGestion = new LIFO<>();
        pilaCuidados = new LIFO<>();
        pilaCuidadosDos = new LIFO<>();
        pilaCuidadosGestion = new LIFO<>();
    }

    public void pushAnimalAction(AccionRealizadaAnimal animal) {
        pilaAnimales.push(animal);
    }

    public AccionRealizadaAnimal popAnimalAction() {
        return pilaAnimales.pop();
    }

    public void resetAnimalAction() {
        pilaAnimales.reset();
    }

    public boolean isEmptyAnimalAction() {
        return pilaAnimales.isEmpty();
    }

    public void pushAnimalActionDos(AccionRealizadaAnimal animal) {
        pilaAnimalesDos.push(animal);
    }

    public AccionRealizadaAnimal popAnimalActionDos() {
        return pilaAnimalesDos.pop();
    }

    public void resetAnimalActionDos() {
        pilaAnimalesDos.reset();
    }

    public boolean isEmptyAnimalActionDos() {
        return pilaAnimalesDos.isEmpty();
    }

    public void pushDiagnosticoAction(AccionRealizadaDiagnostico diagnostico) {
        pilaHistorial.push(diagnostico);
    }

    public AccionRealizadaDiagnostico popDiagnosticoAction() {
        return pilaHistorial.pop();
    }

    public void resetDiagnosticoAction() {
        pilaHistorial.reset();
    }

    public int getSizeDiagnosticoAction() {
        return pilaHistorial.getSize();
    }

    public boolean isEmptyDiagnosticoAction() {
        return pilaHistorial.isEmpty();
    }

    public void pushDiagnosticoActionGestion(AccionRealizadaDiagnostico diagnostico) {
        pilaHistorialGestion.push(diagnostico);
    }

    public AccionRealizadaDiagnostico popDiagnosticoActionGestion() {
        return pilaHistorialGestion.pop();
    }

    public void resetDiagnosticoActionGestion() {
        pilaHistorialGestion.reset();
    }

    public int getSizeDiagnosticoActionGestion() {
        return pilaHistorialGestion.getSize();
    }

    public void pushDiagnosticoDosAction(AccionRealizadaDiagnostico diagnostico) {
        pilaHistorialDos.push(diagnostico);
    }

    public AccionRealizadaDiagnostico popDiagnosticoDosAction() {
        return pilaHistorialDos.pop();
    }

    public void resetDiagnosticoDosAction() {
        pilaHistorialDos.reset();
    }

    public int getSizeDiagnosticoDosAction() {
        return pilaHistorialDos.getSize();
    }
    
        public boolean isEmptyDiagnosticoActionDos() {
        return pilaHistorialDos.isEmpty();
    }

    public void pushPremioAction(AccionRealizadaPremio premio) {
        pilaPremios.push(premio);
    }

    public AccionRealizadaPremio popPremioAction() {
        return pilaPremios.pop();
    }

    public void resetPremioAction() {
        pilaPremios.reset();
    }

    public boolean isEmptyPremioAction() {
        return pilaPremios.isEmpty();
    }

    public int getSizePremioAction() {
        return pilaPremios.getSize();
    }

    public void pushPremioActionDos(AccionRealizadaPremio premio) {
        pilaPremiosDos.push(premio);
    }

    public AccionRealizadaPremio popPremioActionDos() {
        return pilaPremiosDos.pop();
    }

    public void resetPremioActionDos() {
        pilaPremiosDos.reset();
    }

    public boolean isEmptyPremioActionDos() {
        return pilaPremiosDos.isEmpty();
    }

    public void pushPremioActionGestion(AccionRealizadaPremio premio) {
        pilaPremiosGestion.push(premio);
    }

    public AccionRealizadaPremio popPremioActionGestion() {
        return pilaPremiosGestion.pop();
    }

    public void resetPremioActionGestion() {
        pilaPremiosGestion.reset();
    }

    public boolean isEmptyPremioActionGestion() {
        return pilaPremiosGestion.isEmpty();
    }

    public int getSizePremioActionGestion() {
        return pilaPremiosGestion.getSize();
    }

    public void pushCuidadoAction(AccionRealizadaCuidado cuidado) {
        pilaCuidados.push(cuidado);
    }

    public AccionRealizadaCuidado popCuidadoAction() {
        return pilaCuidados.pop();
    }

    public void resetCuidadoAction() {
        pilaCuidados.reset();
    }

    public boolean isEmptyCuidadoAction() {
        return pilaCuidados.isEmpty();
    }

    public void pushCuidadoActionDos(AccionRealizadaCuidado cuidado) {
        pilaCuidadosDos.push(cuidado);
    }

    public AccionRealizadaCuidado popCuidadoActionDos() {
        return pilaCuidadosDos.pop();
    }

    public void resetCuidadoActionDos() {
        pilaCuidadosDos.reset();
    }

    public boolean isEmptyCuidadoActionDos() {
        return pilaCuidadosDos.isEmpty();
    }

    public void pushCuidadoActionGestion(AccionRealizadaCuidado cuidado) {
        pilaCuidadosGestion.push(cuidado);
    }

    public AccionRealizadaCuidado popCuidadoActionGestion() {
        return pilaCuidadosGestion.pop();
    }

    public void resetCuidadoActionGestion() {
        pilaCuidadosGestion.reset();
    }

    public boolean isEmptyCuidadoActionGestion() {
        return pilaCuidadosGestion.isEmpty();
    }

    public int getSizeCuidadoActionGestion() {
        return pilaCuidadosGestion.getSize();
    }

    public void pushEliminacionAction(AccionRealizadaEliminacion eliminacion) {
        pilaEliminaciones.push(eliminacion);
    }

    public AccionRealizadaEliminacion popEliminacionAction() {
        return pilaEliminaciones.pop();
    }

    public void resetEliminacionAction() {
        pilaEliminaciones.reset();
    }

    public int getSizeEliminacionAction() {
        return pilaEliminaciones.getSize();
    }

    public boolean isEmptyEliminacionAction() {
        return pilaEliminaciones.isEmpty();
    }

    public void pushVentaAction(AccionRealizadaVenta venta) {
        pilaVentas.push(venta);
    }

    public AccionRealizadaVenta popVentaAction() {
        return pilaVentas.pop();
    }

    public void resetVentaAction() {
        pilaVentas.reset();
    }

    public int getSizeVentaAction() {
        return pilaVentas.getSize();
    }

    public boolean isEmptyVentaAction() {
        return pilaVentas.isEmpty();
    }
}
