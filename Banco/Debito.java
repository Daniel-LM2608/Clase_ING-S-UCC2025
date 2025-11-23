// Clase Debito
// Representa una cuenta bancaria de débito.
// Esta cuenta solo puede usar el dinero disponible: no permite saldos negativos.
// Hereda de la clase abstracta Cuenta.

public class Debito extends Cuenta {

    // Constructor
    // Recibe un ID y un monto de apertura.
    // Llama al constructor de la clase base (Cuenta).
    public Debito(int id, double apertura) {
        super(id, apertura);
    }

    // Método apertura
    // Se usa para agregar dinero a la cuenta (depósito).
    // En débito simplemente suma el monto al saldo.
    @Override
    public void apertura(double apertura) {
        montoActual += apertura;
    }

    // Método retirar
    // Permite retirar dinero SOLO si hay fondos suficientes.
    // Retorna true si el retiro fue exitoso, o false si falla.
    public boolean retirar(double cantidad) {
        if (cantidad <= 0)
            return false; // No se permite retirar valores negativos o cero

        if (montoActual < cantidad)
            return false; // Fondos insuficientes

        montoActual -= cantidad; // Se descuenta el monto
        return true;
    }

    // Método para consultar saldo
    // Retorna el monto actual disponible.
    @Override
    public double consultarSaldo() {
        return montoActual;
    }

    // Representación textual de la cuenta
    @Override
    public String toString() {
        return "Cuenta Débito | ID: " + getId() + " | Saldo: " + montoActual;
    }
}