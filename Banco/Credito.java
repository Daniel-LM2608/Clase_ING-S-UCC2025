public class Credito extends Cuenta {
    private double interes = 0.15;
    public Credito(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    public void sumarInteres(double cantidad){
        
    }

    @Override
    public double consultarSaldo() {
        return getMontoActual();
    }   

    
}