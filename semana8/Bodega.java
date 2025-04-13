public class Bodega extends Equipaje {
    private static final double CAPACIDAD = 8.0;

    public Bodega(double peso, double tamanio, double precioBase) {
        super(peso, tamanio, precioBase);
    }

    public Bodega() {
        super();
    }

    @Override
    public double calcularPrecio() {
        double precioTotal = getPrecioBase() + (getPeso() * getTamanio() * CAPACIDAD);
        System.out.println("Precio Bodega calculado: " + precioTotal); // Agregado para depuración
        return precioTotal;
    }

    public String mostrarInformacion() {
        return "Equipaje de Bodega\n" +
               "Peso: " + getPeso() + "\n" +
               "Tamaño: " + getTamanio() + "\n" +
               "Precio Base: " + getPrecioBase() + "\n" +
               "Precio Total: " + calcularPrecio();
    }
}
