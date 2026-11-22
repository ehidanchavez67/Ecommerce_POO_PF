import java.util.ArrayList;

/**
 *
 * @author Luis Antonio Amado Segura Garcia
 */
public class Pedido {
    // Atributos privados
    private static int contadorPedidos = 0;
    private int idPedido;
    private Cliente cliente;
    private ArrayList<ItemPedido> items;
    private Domicilio domicilioEntrega;
    private MedioPago medioPago;
    private float totalPagado;
    private boolean confirmado;

    // Método constructor
    public Pedido(Cliente cliente, ArrayList<ItemPedido> items, Domicilio domicilioEntrega, MedioPago medioPago) {
        if (cliente == null) {
            throw new RuntimeException("El pedido debe estar asociado a un cliente...");
        }
        if (items == null || items.isEmpty()) {
            throw new RuntimeException("No se puede confirmar una compra con el carrito vacío...");
        }
        if (domicilioEntrega == null) {
            throw new RuntimeException("No se puede confirmar una compra sin domicilio registrado...");
        }
        if (medioPago == null) {
            throw new RuntimeException("No se puede confirmar una compra sin medio de pago registrado...");
        }

        contadorPedidos += 1;
        this.idPedido = contadorPedidos;
        this.cliente = cliente;
        this.items = new ArrayList<>(items); // Esta sección copia para que al vaciar el carrito no se borre el pedido
        this.domicilioEntrega = domicilioEntrega;
        this.medioPago = medioPago;
        this.totalPagado = calcularTotal();
        this.confirmado = true;
    }

    // Métodos
    public float calcularTotal() {
        float suma = 0.0f;
        for (ItemPedido item : this.items) {
            suma += item.calcularSubtotal();
        }
        this.totalPagado = suma;
        return this.totalPagado;
    }

    public Ticket generarTicketInicial() {
        Ticket ticket = new Ticket(this);
        ticket.escribirArchivoTicket(false);
        return ticket;
    }

    public Ticket reimprimirTicket() {
        if (!this.confirmado) {
            throw new RuntimeException("El pedido aún no ha sido confirmado...");
        }
        Ticket ticket = new Ticket(this);
        ticket.escribirArchivoTicket(true);
        return ticket;
    }

    // Métodos auxiliares para la Opción 7 del Cliente (Imprimir ticket de un pedido)
    public static void mostrarPedidosConfirmados(ArrayList<Pedido> pedidos) {
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("No tienes pedidos confirmados registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE PEDIDOS CONFIRMADOS ---");
        for (Pedido p : pedidos) {
            System.out.println("ID Pedido: " + p.getIdPedido()
                    + "\t | Productos distintos: " + p.getItems().size()
                    + "\t | Total pagado: $" + p.getTotalPagado());
        }
    }

    public static Pedido buscarPedidoPorId(ArrayList<Pedido> pedidos, int idBuscado) {
        if (pedidos == null) {
            return null;
        }
        for (Pedido p : pedidos) {
            if (p.getIdPedido() == idBuscado) {
                return p;
            }
        }
        return null;
    }

    // Getters y Setters
    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public Domicilio getDomicilioEntrega() {
        return domicilioEntrega;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public float getTotalPagado() {
        return totalPagado;
    }

    public boolean isConfirmado() {
        return confirmado;
    }
}
