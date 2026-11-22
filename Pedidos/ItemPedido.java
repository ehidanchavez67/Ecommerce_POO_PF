/**
 *
 * @author Luis Antonio Amado Segura Garcia
 */
public class ItemPedido {
    // Atributos privados
    private Producto producto;
    private int cantidad;
    private float precioUnitario;
    private float subtotal;

    // Método constructor
    public ItemPedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new RuntimeException("El producto no puede estar vacío...");
        }
        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a cero...");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
        this.subtotal = calcularSubtotal();
    }

    // Métodos
    public float calcularSubtotal() {
        this.subtotal = this.precioUnitario * this.cantidad;
        return this.subtotal;
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
            calcularSubtotal();
        }
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public float getSubtotal() {
        return subtotal;
    }
}
