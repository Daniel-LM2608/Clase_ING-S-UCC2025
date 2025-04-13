public class Cabina extends Equipaje {
    private static final int TIEMPO = 2;

    // Constructor por defecto
    public Cabina() {
        super();
    }

    // Constructor con parámetros
    public Cabina(double peso, double tamanio, double precioBase) {
        super(peso, tamanio, precioBase);
    }

    @Override
    public double calcularPrecio() {
        double precioTotal = getPrecioBase() + (getPeso() * getTamanio() * TIEMPO);
        System.out.println("Precio Cabina calculado: " + precioTotal); // Agregado para depuración
        return precioTotal;
    }

    public String mostrarInformacion() {
        return "Equipaje de Cabina\n" +
               "Peso: " + getPeso() + "\n" +
               "Tamaño: " + getTamanio() + "\n" +
               "Precio Base: " + getPrecioBase() + "\n" +
               "Precio Total: " + calcularPrecio();
    }
}

