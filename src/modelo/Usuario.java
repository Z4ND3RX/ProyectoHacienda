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
public class Usuario extends Persona {

    private String usuario;
    private String password;

    public Usuario(String usuario, String password, String nombre, String apellido, String telefono, String documento) {
        super(nombre, apellido, telefono, documento);
        this.usuario = usuario;
        this.password = password;
    }

    public void setAll(String nombre, String apellido, String telefono,
            String documento, String Usuario, String Password) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setTelefono(telefono);
        this.setDocumento(documento);
        this.setUsuario(Usuario);
        this.setPassword(Password);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
