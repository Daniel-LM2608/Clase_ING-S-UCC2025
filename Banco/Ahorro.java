public class Ahorro extends Cuenta {
    private double interes = 0.10; // 10% ejemplo

    public Ahorro(int id, double apertura) {
        super(id, apertura);
    }

    @Override
    public void apertura(double apertura) {
        // Aumenta el saldo
        montoActual += apertura;
    }

    public void invertir(double cantidad) {
        if (cantidad <= 0)
            return;
        montoActual += cantidad;
        // aplicar interés sobre el total (ejemplo simple)
        montoActual += montoActual * interes;
    }

    @Override
    public double consultarSaldo() {
        return montoActual;
    }

    @Override
    public String toString() {
        return "Cuenta Ahorro | ID: " + getId() + " | Saldo: " + montoActual;
    }
}