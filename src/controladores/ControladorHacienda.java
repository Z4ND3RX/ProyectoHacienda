/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import excepciones.NombreDeUsuarioEnUsoException;
import excepciones.PersonaYaRegistradaException;
import java.io.IOException;
import modelo.Administrador;
import modelo.Usuario;
import util.LSE;
import util.Nodo;
import util.Serializadora;

/**
 *
 * @author andre
 */
public class ControladorHacienda {

    LSE<Usuario> listaUsuarios;
    Serializadora serializadoraUsuarios;

    public ControladorHacienda() {
        serializadoraUsuarios = new Serializadora();
        listaUsuarios = inicializarLista();
    }

    private LSE<Usuario> inicializarLista() {
        LSE<Usuario> listaUsers;
        try {
            listaUsers = serializadoraUsuarios.leerUsuarios();
            return listaUsers;
        } catch (IOException | ClassNotFoundException | NullPointerException ex) {
            return new LSE<>();
        }
    }

    public void escribirUsuarios() {
        try {
            serializadoraUsuarios.escribirUsuarios(listaUsuarios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void añadirUsuario(Usuario user) throws PersonaYaRegistradaException, NombreDeUsuarioEnUsoException {
        for (int i = 0; i < listaUsuarios.getSize(); i++) {
            if (user.getDocumento().equals(listaUsuarios.get(i).getDocumento())) {
                throw new PersonaYaRegistradaException();
            }
            if (user.getUsuario().equals(listaUsuarios.get(i).getUsuario())) {
                throw new NombreDeUsuarioEnUsoException();
            }
        }
        listaUsuarios.add(user);
        escribirUsuarios();
    }

    public Usuario buscarUsuario(String user, String password) {
        for (int i = 0; i < listaUsuarios.getSize(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(user) && listaUsuarios.get(i).getPassword().equals(password)) {
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

    public int buscarUsuarioDocumento(String documento) {
        for (int i = 0; i < listaUsuarios.getSize(); i++) {
            if (listaUsuarios.get(i).getDocumento().equals(documento)) {
                return i;
            }
        }
        return -1;
    }

    public Usuario obtenerUsuario(int index) {
        return listaUsuarios.get(index);
    }

    public void eliminarUsuario(int index) {
        listaUsuarios.delete(index);
        escribirUsuarios();
    }

    public void editarUsuario(int index, String nombre, String apellido, String telefono, String password) {
        Usuario user = obtenerUsuario(index);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setTelefono(telefono);
        user.setPassword(password);
        listaUsuarios.edit(index, user);
        escribirUsuarios();
    }

    public int getSizeUsuarios() {
        return listaUsuarios.getSize();
    }
}
