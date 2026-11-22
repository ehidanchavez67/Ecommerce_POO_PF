package catalogo;


import exepciones.ProductoDuplicadoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author The helloWorld("print")
 */
public class Catalogo {

    // LinkedHashMap conserva el orden de inserción
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public void agregar(Producto producto) throws ProductoDuplicadoException {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        // put reemplazaría al producto existente sin avisar, por eso se pregunta antes.
        if (productos.containsKey(producto.getId())) {
            throw new ProductoDuplicadoException(producto.getId());
        }
        productos.put(producto.getId(), producto);
    }

    // Devuelve null si el id no existe
    public Producto buscarPorId(String id) {
        if (id == null) {
            return null;
        }
        return productos.get(id.strip());
    }

    public boolean existe(String id) {
        return buscarPorId(id) != null;
    }

    public List<Producto> listar() {
        return Collections.unmodifiableList(new ArrayList<>(productos.values()));
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}