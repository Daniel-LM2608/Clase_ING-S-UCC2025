public class Ahorro extends Cuenta {

    private double interes = 0.1;

    public Ahorro(int id, double apertura) {
        super(id, apertura);
    }

    @Override
    public void apertura(double apertura) {
        montoActual += apertura;
    }

    public void invertir(double cantidad) {
        montoActual += cantidad;
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

