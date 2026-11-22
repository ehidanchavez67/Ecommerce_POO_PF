
package Servicios;

import Usuarios.Usuario;
import excepciones.UsuarioDuplicadoException;
import excepciones.UsuarioNoEncontradoException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author The helloWorld("print")
 */
public class RegistroUsuarios {

    private final Map<String, Usuario> usuarios = new LinkedHashMap<>();

    public void agregar(Usuario usuario) throws UsuarioDuplicadoException {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        if (usuarios.containsKey(usuario.getNombreDeUsuario())) {
            throw new UsuarioDuplicadoException(usuario.getNombreDeUsuario());
        }
        usuarios.put(usuario.getNombreDeUsuario(), usuario);
    }

    public Usuario ingresar(String nombreDeUsuario) throws UsuarioNoEncontradoException {
        if (nombreDeUsuario == null || !usuarios.containsKey(nombreDeUsuario.strip())) {
            throw new UsuarioNoEncontradoException(nombreDeUsuario);
        }
        return usuarios.get(nombreDeUsuario.strip());
    }

    public boolean existe(String nombreDeUsuario) {
        return nombreDeUsuario != null && usuarios.containsKey(nombreDeUsuario.strip());
    }
}