public class Debito extends Cuenta {

    public Debito(int id, double apertura, double montoActual, double cantidad) {
        super(id, apertura, montoActual, cantidad);
    }

    @Override
    public void apertura(double apertura) {
        montoActual = getMontoActual() + apertura;
        setMontoActual(montoActual);
    }

    public void retirar(double cantidad) {
        montoActual = getMontoActual() - cantidad;
        setMontoActual(montoActual);
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }
}
