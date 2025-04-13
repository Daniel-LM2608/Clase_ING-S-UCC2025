public class Bodega extends Equipaje {
    // Constantes
    private static final double CAPACIDAD = 8.0;

    // Constructor con parámetros
    public Bodega(double peso, double tamanio, double precioBase) {
        super(peso, tamanio, precioBase);
    }

    // Constructor por defecto (opcional)
    public Bodega() {
        super(); // Usa valores por defecto definidos en Equipaje
    }

    // Método sobrescrito para calcular el precio
    @Override
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamanio() * CAPACIDAD);
    }

    // Método para mostrar información
    public String mostrarInformacion() {
        return "Equipaje de Bodega\n" +
               "Peso: " + getPeso() + "\n" +
               "Tamaño: " + getTamanio() + "\n" +
               "Precio Base: " + getPrecioBase() + "\n" +
               "Precio Total: " + calcularPrecio();
    }
}
