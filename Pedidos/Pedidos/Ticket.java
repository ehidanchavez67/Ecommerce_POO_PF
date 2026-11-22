import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Luis Antonio Amado Segura Garcia
 */
public class Ticket {
    // Atributos privados
    private static int contadorTickets = 0;

    private int idTicket;
    private Pedido pedido;
    private String nombreArchivo;

    // Método constructor
    public Ticket(Pedido pedido) {
        if (pedido == null) {
            throw new RuntimeException("No se puede generar un ticket sin un pedido válido...");
        }
        contadorTickets += 1;
        this.idTicket = contadorTickets;
        this.pedido = pedido;
        this.nombreArchivo = "tickets" + File.separator + "Ticket_Pedido_" + pedido.getIdPedido() + ".txt";
    }

    // Métodos
    public void escribirArchivoTicket(boolean esReimpresion) {
        // Se creará la instancia que nombre al directorio "tickets".
        File carpetaTickets = new File("tickets");

        // Realizar el condicional de crear el directorio en caso de que no exista.
        if (!carpetaTickets.exists()) {
            carpetaTickets.mkdir();
        }

        try {
            // Instancia del escritor.
            BufferedWriter escritor = new BufferedWriter(new FileWriter(this.nombreArchivo));

            // Escribir encabezado y datos generales.
            
            escritor.write("               ——TICKET DE COMPRA - E-COMMERCE ——               ");
            escritor.newLine();
            if (esReimpresion) {
                escritor.write("               ### REIMPRESIÓN DE TICKET ###                ");
                escritor.newLine();
            }
            escritor.write("Folio de Ticket: " + this.idTicket);
            escritor.newLine();
            escritor.write("ID de Pedido: " + this.pedido.getIdPedido());
            escritor.newLine();
            escritor.write("Cliente: " + this.pedido.getCliente().getNombreCompleto()
                    + " (" + this.pedido.getCliente().getNombreUsuario() + ")");
            escritor.newLine();
            escritor.write("Domicilio de entrega: " + this.pedido.getDomicilioEntrega().getCalle()
                    + ", Col. " + this.pedido.getDomicilioEntrega().getColonia());
            escritor.newLine();
            escritor.write("Medio de pago utilizado: " + this.pedido.getMedioPago().toString());
            escritor.newLine();
            escritor.write("PRODUCTOS COMPRADOS:");
            escritor.newLine();

            // Escribir cada producto comprado con su cantidad y subtotal.
            for (ItemPedido item : this.pedido.getItems()) {
                String lineaProducto = "- " + item.getProducto().getNombre()
                        + "\t | Cantidad: " + item.getCantidad()
                        + "\t | P. Unitario: $" + item.getPrecioUnitario()
                        + "\t | Subtotal: $" + item.getSubtotal();
                escritor.write(lineaProducto);
                escritor.newLine();
            }

            escritor.write("TOTAL PAGADO: $" + this.pedido.getTotalPagado());
            escritor.newLine();

            // Finalizamos al escritor.
            escritor.close();

            if (esReimpresion) {
                System.out.println("Ticket reimpreso correctamente en: " + this.nombreArchivo);
            } else {
                System.out.println("Ticket generado correctamente en: " + this.nombreArchivo);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error en la escritura del ticket...");
        }
    }

    public void leerTicket() {
        try {
            String linea;
            BufferedReader lector = new BufferedReader(new FileReader(this.nombreArchivo));

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo del ticket seleccionado.");
        }
    }

    // Getters y Setters
    public int getIdTicket() {
        return idTicket;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }
}
