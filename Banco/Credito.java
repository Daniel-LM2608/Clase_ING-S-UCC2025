public class Credito extends Cuenta {

    private double interes = 0.15;

    public Credito(int id, double apertura) {
        super(id, 0); // crédito inicia con deuda 0
    }

    public void usarCredito(double cantidad) {
        montoActual -= cantidad; // aumenta deuda
    }

    public void aplicarInteres() {
        if (montoActual < 0) {
            montoActual += montoActual * interes;
        }
    }

    public void pagar(double cantidad) {
        montoActual += cantidad; // reduce deuda
    }

    @Override
    public void apertura(double apertura) {
        // no hace nada al abrir
    }

    @Override
    public double consultarSaldo() {
        return montoActual;
    }

    @Override
    public String toString() {
        return "Cuenta Crédito | ID: " + getId() + " | Deuda: " + montoActual;
    }
}
