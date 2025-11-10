public class Ahorro extends Cuenta {
    public Ahorro(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }
    @Override
    public void apertura(double apertura) {
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }

    
}