public class Cuenta {

    private int id;               // ← Nuevo ID de la cuenta
    private double apertura;
    protected double montoActual = 0;
    protected double cantidad;

    // Constructor ACTUALIZADO con ID
    public Cuenta(int id, double apertura, double montoActual, double cantidad) {
        this.id = id;
        this.apertura = apertura;
        this.montoActual = montoActual;
        this.cantidad = cantidad;
    }

    // Getter del ID
    public int getId() {
        return id;
    }

    // Setter del ID (si llegara a hacer falta)
    public void setId(int id) {
        this.id = id;
    }

    public double getApertura() {
        return apertura;
    }

    public void setApertura(double apertura) {
        this.apertura = apertura;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void apertura(double apertura) {
        // Se sobreescribe en clases hijas
    }

    public double consultarSaldo() {
        return montoActual;
    }
}
