package catalogo;

import excepciones.PrecioInvalidoException;
import java.util.Objects;

/**
 *
 * @author The helloWorld("print")
 */
public class Producto {
    
    private final String id;
    private final String nombre;
    private final String categoria;
    private double precio;
    
    private static String validarTexto(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return texto.strip();
    }
    
    private static double validarPrecio(double precio) throws PrecioInvalidoException {
        if(precio <= 0 || Double.isInfinite(precio)) {
            throw new PrecioInvalidoException(precio);
        }  
    return precio;   
    }  

    public Producto(String id, String nombre, String categoria, double precio) throws PrecioInvalidoException {
        this.id = validarTexto(id, "El identificador");
        this.nombre = validarTexto(nombre, "El nombre");
        this.categoria = validarTexto(categoria, "La categoria");
        this.precio = validarPrecio(precio);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nuevoPrecio) throws PrecioInvalidoException {
        this.precio = validarPrecio(nuevoPrecio);
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        Producto otro = (Producto) obj;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + categoria + " | $" + String.format("%.2f", precio);
    }
  
}
