public class Equipaje {
    // Constantes
    private static final double PESO = 10.0;         // Peso por defecto
    private static final double TAMANIO = 4.5;       // Tamaño por defecto
    private static final double PRECIO_BASE = 1000.0;// Precio base por defecto

    // Atributos
    private double peso;
    private double tamanio;
    private double precioBase;

    // Constructores

    // 1. Constructor por defecto
    public Equipaje() {
        this.peso = PESO;
        this.tamanio = TAMANIO;
        this.precioBase = PRECIO_BASE;
    }

    // 2. Constructor con todos los parámetros
    public Equipaje(double peso, double tamanio, double precioBase) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
    }

    // 3. Constructor con peso y tamaño (usa precio base por defecto)
    public Equipaje(double peso, double tamanio) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = PRECIO_BASE;
    }

    // 4. Constructor con solo precio base (usa peso y tamaño por defecto)
    public Equipaje(double precioBase) {
        this.peso = PESO;
        this.tamanio = TAMANIO;
        this.precioBase = precioBase;
    }

    // Método calcularPrecio (por ahora devuelve 0.0 como placeholder)
    public double calcularPrecio() {
        return 0.0;
    }

    // Getters
    public double getPeso() {
        return peso;
    }

    public double getTamanio() { 
        return tamanio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // Setters
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

