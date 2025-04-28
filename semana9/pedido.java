import java.util.Date;

/**
 * Clase Pedido
 * Representa un pedido realizado por un cliente, que contiene varios productos.
 */
public class Pedido {
    // Atributos privados
    private Cliente cliente; // Agregación: el pedido tiene un cliente
    private Producto[] productos; // Agregación: el pedido tiene productos (pueden ser Impresion o Camara)
    private Date fecha;
    private int numeroTarjetaCredito;

    /**
     * Constructor de la clase Pedido.
     * 
     * @param cliente              Cliente que realiza el pedido.
     * @param productos            Arreglo de productos pedidos.
     * @param fecha                Fecha del pedido.
     * @param numeroTarjetaCredito Número de tarjeta de crédito utilizado.
     */
    public Pedido(Cliente cliente, Producto[] productos, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeroTarjetaCredito(int numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    /**
     * Método para mostrar toda la información del pedido.
     * 
     * @return Información detallada del pedido como String.
     */
    public String mostrarInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido realizado por: ").append(cliente.mostrarInformacion()).append("\n")
                .append("Fecha: ").append(fecha).append("\n")
                .append("Número de Tarjeta: ").append(numeroTarjetaCredito).append("\n")
                .append("Productos:\n");

        if (productos != null && productos.length > 0) {
            for (Producto producto : productos) {
                sb.append("- ").append(producto.mostrarInformacion()).append("\n");
            }
        } else {
            sb.append("No hay productos en este pedido.\n");
        }

        return sb.toString();
    }
}
