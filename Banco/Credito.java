public class Credito extends Cuenta {
      private double interes = 0.15; // 15%

    public Credito(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    // El usuario usa dinero del crédito (se endeuda)
    public void usarCredito(double cantidad) {
        montoActual -= cantidad; // aumenta la deuda
    }

    // Se aplica interés sobre la deuda (si la hay)
    public void aplicarInteres() {
        if (montoActual < 0) { 
            montoActual = montoActual + (montoActual * interes); // más deuda
        }
    }

    // El usuario abona (paga su deuda)
    public void pagar(double cantidad) {
        montoActual += cantidad;
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual(); 
    }
}

    
