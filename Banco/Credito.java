public class Credito extends Cuenta {
    private double interes = 0.15; // 15% anual (ejemplo)

    // Para crédito guardamos la deuda en montoActual como número NEGATIVO
    public Credito(int id, double apertura) {
        super(id, 0); // inicia sin deuda a menos que se use crédito
        // Si se desea crear con deuda inicial, se puede usar setMontoActual
    }

    public void usarCredito(double cantidad) {
        if (cantidad <= 0)
            return;
        // aumentar deuda -> montoActual será más negativo
        montoActual -= cantidad;
    }

    public void aplicarInteres() {
        if (montoActual < 0) {
            // montoActual es negativo, queremos hacerlo más negativo multiplicando
            montoActual += montoActual * interes; // ejemplo: -100 + (-100*0.15) = -115
        }
    }

    public void pagar(double cantidad) {
        if (cantidad <= 0)
            return;
        montoActual += cantidad; // reduce deuda
    }

    @Override
    public void apertura(double apertura) {
        // No aplica para crédito al abrir
    }

    @Override
    public double consultarSaldo() {
        return montoActual; // negativo = deuda
    }

    @Override
    public String toString() {
        return "Cuenta Crédito | ID: " + getId() + " | Deuda: " + montoActual;
    }
}