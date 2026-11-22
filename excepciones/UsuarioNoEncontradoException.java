package excepciones;

/**
 *
 * @author The helloWorld("print")
 */
public class UsuarioNoEncontradoException extends Exception {
    
    private final String nombreDeUsuario;

    public UsuarioNoEncontradoException(String nombreDeUsuario) {
        super("No existe un usuario con el nombre: " + nombreDeUsuario);
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
}
