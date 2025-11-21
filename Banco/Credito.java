public class Credito extends Cuenta {

    private double interes = 0.15;

    public Credito(int id, double apertura, double montoActual, double cantidad) {
        super(id, apertura, montoActual, cantidad);
    }

    public void usarCredito(double cantidad) {
        montoActual -= cantidad;
    }

    public void aplicarInteres() {
        if (montoActual < 0) {
            montoActual = montoActual + (montoActual * interes);
        }
    }

    public void pagar(double cantidad) {
        montoActual += cantidad;
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }
}

    
