public class Debito extends Cuenta {
    public Debito(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    @Override
    public void apertura(double apertura) {
        if (apertura > 0) {
            montoActual += apertura;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: el monto a retirar debe ser mayor que 0.");
            return;
        }

        if (cantidad > montoActual) {
            System.out.println("Fondos insuficientes.");
            return;
        }

        montoActual -= cantidad;
    }

    @Override
    public double consultarSaldo() {
        return montoActual;
    }
}