public class Cabina extends Equipaje {
    // Constantes
    private static final int TIEMPO = 2;

    // Constructor por defecto
    public Cabina() {
        super(); // Llama al constructor por defecto de Equipaje
    }

    // Constructor con parámetros
    public Cabina(double peso, double tamanio, double precioFinal) {
        super(peso, tamanio, 1000); // Precio base fijo en 1000
    }

    // Método sobrescrito para calcular el precio
    @Override//“es una reescritura (override) de un método que existe en la clase padre o interfaz,""
            // "me dice si hay algun error, me protege de errores ”
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamanio() * TIEMPO);
    }

    // Método para mostrar información del equipaje
    public String mostrarInformacion() {
        return "Equipaje de Cabina\n" +
               "Peso: " + getPeso() + "\n" +
               "Tamaño: " + getTamanio() + "\n" +
               "Precio Base: " + getPrecioBase() + "\n" +
               "Precio Total: " + calcularPrecio();
    }
}
