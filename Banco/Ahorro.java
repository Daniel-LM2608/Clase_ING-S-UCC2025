// Clase que representa una cuenta de ahorro, hereda de Cuenta
public class Ahorro extends Cuenta {
    private double interes = 0.10; // Tasa de interés anual (10% de ejemplo)

    // Constructor de la cuenta de ahorro
    public Ahorro(int id, double apertura) {
        super(id, apertura); // Llama al constructor de Cuenta con el monto inicial de apertura
    }

    // Método para aumentar el saldo al abrir la cuenta
    @Override
    public void apertura(double apertura) {
        montoActual += apertura; // Suma el monto de apertura al saldo actual
    }

    // Método para invertir dinero en la cuenta y aplicar interés
    public void invertir(double cantidad) {
        if (cantidad <= 0)      // No hacer nada si la cantidad es cero o negativa
            return;
        montoActual += cantidad;    // Suma el dinero invertido al saldo
        montoActual += montoActual * interes; // Aplica interés sobre el saldo total
    }

    // Método para consultar el saldo actual de la cuenta
    @Override
    public double consultarSaldo() {
        return montoActual;      // Retorna el saldo actual
    }

    // Representación en texto de la cuenta de ahorro
    @Override
    public String toString() {
        return "Cuenta Ahorro | ID: " + getId() + " | Saldo: " + montoActual;
        // Muestra el ID de la cuenta y el saldo actual
    }
}
