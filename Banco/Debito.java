public class Debito extends Cuenta {
    public Debito(int id, double apertura) {
        super(id, apertura);
    }

    @Override
    public void apertura(double apertura) {
        montoActual += apertura;
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= 0)
            return false;
        if (montoActual < cantidad)
            return false;
        montoActual -= cantidad;
        return true;
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