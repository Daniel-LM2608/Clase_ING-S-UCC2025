public class Equipaje {
    private static final double PESO = 10.0;
    private static final double TAMANIO = 4.5;
    private static final double PRECIO_BASE = 1000.0;

    private double peso;
    private double tamanio;
    private double precioBase;

    // Constructores
    public Equipaje() {
        this.peso = PESO; // this para asignar un valor dado al atributo de un objeto
        // los nombres de los parámetros (los que están entre paréntesis) son idénticos
        // a los atributos del objeto.
        // Entonces usamos this. para indicar que nos referimos al atributo del objeto y
        // no al parámetro local.
        this.tamanio = TAMANIO;
        this.precioBase = PRECIO_BASE;
    }

    public Equipaje(double peso, double tamanio, double precioBase) { // Este constructor recibe tres valores como
                                                                      // parámetros
        // (peso, tamanio, y precioBase) y los asigna a los atributos del objeto
        // Equipaje.
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
}
