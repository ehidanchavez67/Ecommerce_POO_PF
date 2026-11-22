package Datos;

import Servicios.RegistroUsuarios;
import Usuarios.Administrador;
import catalogo.Catalogo;
import catalogo.Producto;
import excepciones.PrecioInvalidoException;
import excepciones.ProductoDuplicadoException;
import excepciones.UsuarioDuplicadoException;

/**
 *
 * @author DELL Vostro 15
 */
public class CargaInicial {
    
    
 
/**
 * @author The helloWorld("print")
 */
public class CargaInicial {

    public static void cargar(RegistroUsuarios registro, Catalogo catalogo) {
        cargarUsuarios(registro);
        cargarProductos(catalogo);
    }

    private static void cargarUsuarios(RegistroUsuarios registro) {
        registrarUsuario(registro, new Administrador("admin1", "Ana Torres"));
        registrarUsuario(registro, new Administrador("admin2", "Luis Mendoza"));

        registrarUsuario(registro, new Cliente("cliente1", "Carlos Ramírez"));
        registrarUsuario(registro, new Cliente("cliente2", "María López"));
        registrarUsuario(registro, new Cliente("cliente3", "Jorge Hernández"));
    }

    private static void cargarProductos(Catalogo catalogo) {
        registrarProducto(catalogo, "P01", "Laptop", "Computación", 15999.00);
        registrarProducto(catalogo, "P02", "Mouse inalámbrico", "Computación", 349.90);
        registrarProducto(catalogo, "P03", "Teclado mecánico", "Computación", 1199.00);
        registrarProducto(catalogo, "P04", "Audífonos", "Audio", 899.50);
        registrarProducto(catalogo, "P05", "Bocina Bluetooth", "Audio", 1299.00);
        registrarProducto(catalogo, "P06", "Cafetera", "Hogar", 1450.00);
        registrarProducto(catalogo, "P07", "Licuadora", "Hogar", 999.00);
        registrarProducto(catalogo, "P08", "Mochila", "Accesorios", 599.00);
    }

    private static void registrarUsuario(RegistroUsuarios registro, Usuario usuario) {
        try {
            registro.agregar(usuario);
        } catch (UsuarioDuplicadoException e) {
            System.out.println("Carga inicial: " + e.getMessage());
        }
    }

    private static void registrarProducto(Catalogo catalogo, String id, String nombre,
            String categoria, double precio) {
        try {
            catalogo.agregar(new Producto(id, nombre, categoria, precio));
        } catch (PrecioInvalidoException | ProductoDuplicadoException e) {
            System.out.println("Carga inicial: " + e.getMessage());
        }
    }
}