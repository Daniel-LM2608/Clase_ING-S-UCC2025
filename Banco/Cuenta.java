public class Cuenta {
    private double apertura;
    protected double montoActual = 0;
    protected double cantidad; // lo dejamos por compatibilidad con tu diseño original

    public Cuenta(double apertura, double montoActual, double cantidad) {
        this.apertura = Math.max(0, apertura);
        this.montoActual = montoActual;
        this.cantidad = cantidad;
        // Si montoActual es 0, inicializamos con la apertura para consistencia
        if (this.montoActual == 0 && this.apertura > 0) {
            this.montoActual = this.apertura;
        }
    }

    public double getApertura() {
        return apertura;
    }

    public void setApertura(double apertura) {
        if (apertura >= 0) this.apertura = apertura;
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

    /**
     * Apertura: por compatibilidad, suma el monto si es válido.
     */
    public void apertura(double apertura) {
        if (apertura > 0) {
            this.montoActual += apertura;
            this.apertura = apertura;
        }
    }

    /**
     * Deposita una cantidad (método genérico que usarán las clases de operación).
     * Retorna true si se depositó correctamente.
     */
    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        this.montoActual += monto;
        return true;
    }

    /**
     * Retira una cantidad si hay fondos suficientes.
     * Retorna true si retiro exitoso.
     */
    public boolean retirar(double monto) {
        if (monto <= 0) return false;
        if (monto > this.montoActual) return false; // fondos insuficientes
        this.montoActual -= monto;
        return true;
    }

    public double consultarSaldo() {
        return montoActual;
    }
}


