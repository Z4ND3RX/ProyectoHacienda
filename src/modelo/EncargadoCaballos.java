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
public class EncargadoCaballos extends Usuario {

    private String codigoEmpleado;

    public EncargadoCaballos(String usuario, String password, String nombre, String apellido, String telefono, String documento) {
        super(usuario, password, nombre, apellido, telefono, documento);
        this.codigoEmpleado = "CE";
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    
}
