// Clase que representa una cuenta de crédito, hereda de Cuenta
public class Credito extends Cuenta {
    private double interes = 0.15; // Tasa de interés anual (15%)

    // Constructor de la cuenta de crédito
    public Credito(int id, double apertura) {
        super(id, 0);          // Llama al constructor de Cuenta con saldo inicial 0
        // La deuda inicial se puede establecer después con setMontoActual si se desea
    }

    // Método para usar crédito: aumenta la deuda
    public void usarCredito(double cantidad) {
        if (cantidad <= 0)     // Si la cantidad es cero o negativa, no hace nada
            return;
        montoActual -= cantidad; // Se incrementa la deuda, montoActual se vuelve más negativo
    }

    // Método para aplicar interés sobre la deuda
    public void aplicarInteres() {
        if (montoActual < 0) { // Solo aplica interés si hay deuda (saldo negativo)
            // Calcula interés sobre la deuda y lo suma al montoActual
            // Ejemplo: deuda = -100, interés = 15% -> -100 + (-100*0.15) = -115
            montoActual += montoActual * interes;
        }
    }

    // Método para pagar deuda: disminuye el monto de la deuda
    public void pagar(double cantidad) {
        if (cantidad <= 0)     // No hacer nada si la cantidad es cero o negativa
            return;
        montoActual += cantidad; // Se reduce la deuda aumentando el montoActual
    }

    // Método de apertura, no aplica para crédito
    @Override
    public void apertura(double apertura) {
        // No se utiliza para cuentas de crédito al abrir
    }

    // Método para consultar el saldo
    @Override
    public double consultarSaldo() {
        return montoActual;    // Retorna la deuda; negativo indica que se debe dinero
    }

    // Representación en texto de la cuenta de crédito
    @Override
    public String toString() {
        return "Cuenta Crédito | ID: " + getId() + " | Deuda: " + montoActual;
        // Muestra el ID de la cuenta y la deuda actual
    }
}
