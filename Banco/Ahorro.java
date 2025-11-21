public class Ahorro extends Cuenta {
     private double interes = 0.10; // 10%

    public Ahorro(double apertura, double montoActual, double cantidad) {
        super(apertura, montoActual, cantidad);
    }

    @Override
    public void apertura(double apertura) {
        if (apertura > 0) {
            montoActual += apertura;
        }
    }

    // Inversión: agrega el monto y luego aplica interés sobre ese monto invertido
    public void invertir(double cantidad) {
        if (cantidad > 0) {
            montoActual += cantidad;             // Se agrega al saldo
            montoActual += cantidad * interes;   // Se agrega el interés solo sobre la inversión
        }
    }

    @Override
    public double consultarSaldo() {
        return montoActual;
    }

    
}