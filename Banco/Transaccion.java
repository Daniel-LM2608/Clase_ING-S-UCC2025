import java.time.LocalDateTime;       // Para manejar fecha y hora actuales
import java.time.format.DateTimeFormatter; // Para formatear la fecha y hora

// Clase que representa una transacción en una cuenta bancaria
public class Transaccion {
    private int idCuenta;          // ID de la cuenta asociada a la transacción
    private String tipo;           // Tipo de transacción (ej: "depósito", "retiro")
    private double monto;          // Monto de la transacción
    private LocalDateTime fecha;   // Fecha y hora en que se realizó la transacción

    // Constructor de la clase Transaccion
    public Transaccion(int idCuenta, String tipo, double monto) {
        this.idCuenta = idCuenta;  // Asigna el ID de la cuenta
        this.tipo = tipo;          // Asigna el tipo de transacción
        this.monto = monto;        // Asigna el monto de la transacción
        this.fecha = LocalDateTime.now(); // Captura la fecha y hora actual
    }

    // Getter para el ID de la cuenta
    public int getIdCuenta() {
        return idCuenta;
    }

    // Getter para el tipo de transacción
    public String getTipo() {
        return tipo;
    }

    // Getter para el monto de la transacción
    public double getMonto() {
        return monto;
    }

    // Getter para la fecha de la transacción
    public LocalDateTime getFecha() {
        return fecha;
    }

    // Representación en texto de la transacción
    @Override
    public String toString() {
        // Define el formato de la fecha: día/mes/año horas:minutos:segundos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // Retorna un string completo con los datos de la transacción
        return "Transacción | Cuenta: " + idCuenta 
                + " | Tipo: " + tipo 
                + " | Monto: " + monto 
                + " | Fecha: " + fecha.format(formato);
    }
}
