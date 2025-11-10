public class Debito extends Cuenta {
    public Debito(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    @Override
     public void apertura(double apertura) {
        montoActual = getMontoActual() + apertura;
        setMontoActual(montoActual);
     }


     @Override

    public double consultarSaldo() {
        return getMontoActual();
    }
}