package excepciones;

/**
 *
 * @author The helloWorld("print")
 */
public class PrecioInvalidoException extends Exception{
    
    private final double precio;
    
     public PrecioInvalidoException(double precio) {
        super("El precio debe ser mayor que cero. Valor recibido: " + precio);
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
