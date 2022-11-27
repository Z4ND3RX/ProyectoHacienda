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
public class Administrador extends Usuario {

    private String CodigoAdmin;

    public Administrador(String usuario, String password, String nombre, String apellido, String telefono, String documento) {
        super(usuario, password, nombre, apellido, telefono, documento);
        this.CodigoAdmin = "CA";
    }

    public String getCodigoAdmin() {
        return CodigoAdmin;
    }

    public void setCodigoAdmin(String CodigoAdmin) {
        this.CodigoAdmin = CodigoAdmin;
    }

}
