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
public class Veterinario extends Usuario {

    String codigoProfesional;

    public Veterinario(String usuario, String password, String nombre, String apellido, String telefono, String documento) {
        super(usuario, password, nombre, apellido, telefono, documento);
        this.codigoProfesional = "CP";
    }

    public String getCodigoProfesional() {
        return codigoProfesional;
    }

    public void setCodigoProfesional(String codigoProfesional) {
        this.codigoProfesional = codigoProfesional;
    }

}
