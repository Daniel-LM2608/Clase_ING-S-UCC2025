import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {

    private int idCuenta;
    private String tipo;
    private double monto;
    private LocalDateTime fecha;

    public Transaccion(int idCuenta, String tipo, double monto) {
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Transacción | Cuenta: " + idCuenta +
                " | Tipo: " + tipo +
                " | Monto: " + monto +
                " | Fecha: " + fecha.format(formato);
    }
}
