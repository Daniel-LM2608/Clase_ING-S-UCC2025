public class Credito extends Cuenta {
    public Credito(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }   

    
}