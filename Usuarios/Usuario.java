package Usuarios;


import java.util.Objects;

/**
 * @author The helloWorld("print")
 */
public abstract class Usuario {

    private final String nombreDeUsuario;
    private final String nombreCompleto;

    protected Usuario(String nombreDeUsuario, String nombreCompleto) {
        this.nombreDeUsuario = validarTexto(nombreDeUsuario, "El nombre de usuario");
        this.nombreCompleto = validarTexto(nombreCompleto, "El nombre completo");
    }

    private static String validarTexto(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return texto.strip();
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public abstract String getRol();

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario otro = (Usuario) obj;
        return nombreDeUsuario.equals(otro.nombreDeUsuario);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(nombreDeUsuario);
    }

    @Override
    public String toString() {
        return getRol() + " | " + nombreDeUsuario + " | " + nombreCompleto;
    }
}
