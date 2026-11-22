package excepciones;

/**
 *
 * @author The helloWorld("print")
 */
public class UsuarioDuplicadoException extends Exception {
    
    private final String nombreDeUsuario;

    public UsuarioDuplicadoException(String nombreDeUsuario) {
        super("Ya existe un usuario con el nombre: " + nombreDeUsuario);
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
}
