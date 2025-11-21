public class Ahorro extends Cuenta {

    private double interes = 0.1;

    public Ahorro(int id, double apertura, double montoActual, double cantidad) {
        super(id, apertura, montoActual, cantidad);
    }

    @Override
    public void apertura(double apertura) {
        montoActual = getMontoActual() + apertura;
        setMontoActual(montoActual);
    }

    public void invertir(double cantidad) {
        montoActual = getMontoActual() + cantidad;
        montoActual += getMontoActual() * interes;
        setMontoActual(montoActual);
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }
}
