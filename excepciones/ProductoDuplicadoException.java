package excepciones;

/**
 *
 * @author The helloWorld("print")
 */
public class ProductoDuplicadoException extends Exception {
    
    private final String idDuplicado;

    public ProductoDuplicadoException(String idDuplicado) {
        super("Ya existe un producto con el identificador: "+ idDuplicado + "en el sistema");
        this.idDuplicado = idDuplicado;
    }

    public String getIdDuplicado() {
        return idDuplicado;
    }

}
