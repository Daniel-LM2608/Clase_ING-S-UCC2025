public class Equipaje {
    private static final double PESO = 10.0; // Peso por defecto
    private static final double TAMANIO = 4.5; // Tamaño por defecto
    private static final double PRECIO_BASE = 1000.0; // Precio base por defecto

    private double peso;
    private double tamanio;
    private double precioBase;

    // Constructor por defecto
    public Equipaje() {
        this.peso = PESO;
        this.tamanio = TAMANIO;
        this.precioBase = PRECIO_BASE;
    }

    // Constructor con todos los parámetros
    public Equipaje(double peso, double tamanio, double precioBase) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
    }

    public Equipaje(double peso, double tamanio) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = PRECIO_BASE;
    }

    public Equipaje(double precioBase) {
        this.peso = PESO;
        this.tamanio = TAMANIO;
        this.precioBase = precioBase;
    }

    public double calcularPrecio() {
        return 0.0;
    }

    public double getPeso() {
        return peso;
    }

    public double getTamanio() {
        return tamanio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
