public abstract class Cuenta {

    protected double saldo;

    public Cuenta(double aperturaInicial) {
        if (aperturaInicial < 0) {
            aperturaInicial = 0;
        }
        this.saldo = aperturaInicial;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public abstract void apertura(double monto);

}

