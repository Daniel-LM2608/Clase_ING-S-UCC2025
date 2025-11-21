public abstract class Cuenta {

    private int id;
    protected double montoActual;

    public Cuenta(int id, double apertura) {
        this.id = id;
        this.montoActual = apertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public abstract void apertura(double monto);

    public abstract double consultarSaldo();

    @Override
    public abstract String toString();
}
