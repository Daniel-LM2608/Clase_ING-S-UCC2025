public class Ahorro extends Cuenta {
    private double interes = 0.1;
    public Ahorro(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }
    @Override
    public void apertura(double apertura) {
        montoActual = getMontoActual() + apertura;
        setMontoActual(montoActual);
    }

    public void invertir(double cantidad){
        
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }

    
}