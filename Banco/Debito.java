public class Debito extends Cuenta {

    public Debito(int id, double apertura) {
        super(id, apertura);
    }

    @Override
    public void apertura(double apertura) {
        montoActual += apertura;
    }

    public void retirar(double cantidad) {
        montoActual -= cantidad;
    }

    @Override
    public double consultarSaldo() {
        return montoActual;
    }

    @Override
    public String toString() {
        return "Cuenta Débito | ID: " + getId() + " | Saldo: " + montoActual;
    }
}

