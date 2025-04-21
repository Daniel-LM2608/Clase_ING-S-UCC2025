public class Cabina extends Equipaje {
    private static final int TIEMPO = 2;

    public Cabina() { 
        super();
    }

    public Cabina(double peso, double tamanio, double precioFinalIgnorado) {
        super(peso, tamanio, 1000); // siempre precio base 1000
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamanio() * TIEMPO);
    }
}
