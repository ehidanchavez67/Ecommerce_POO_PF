
package Usuarios;

import catalogo.Catalogo;
import catalogo.Producto;
import exepciones.PrecioInvalidoException;
import exepciones.ProductoDuplicadoException;


/**
 * @author The helloWorld("print")
 */
public class Administrador extends Usuario {

    public Administrador(String nombreDeUsuario, String nombreCompleto) {
        super(nombreDeUsuario, nombreCompleto);
    }

    @Override
    public String getRol() {
        return "ADMINISTRADOR";
    }

    public void altaProducto(Catalogo catalogo, String id, String nombre,
            String categoria, double precio)
            throws PrecioInvalidoException, ProductoDuplicadoException, excepciones.PrecioInvalidoException {
        Producto producto = new Producto(id, nombre, categoria, precio);
        catalogo.agregar(producto);
    }

    public boolean modificarPrecio(Catalogo catalogo, String id, double nuevoPrecio)
            throws PrecioInvalidoException, excepciones.PrecioInvalidoException {
        Producto producto = catalogo.buscarPorId(id);
        if (producto == null) {
            return false;
        }
        producto.setPrecio(nuevoPrecio);
        return true;
    }
}