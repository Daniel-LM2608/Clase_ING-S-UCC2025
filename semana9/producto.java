/**
 * Clase abstracta Producto
 * Representa un producto genérico.
 */
public abstract class Producto {
    // Atributo privado
    private int numero;

    /**
     * Constructor de la clase Producto.
     * @param numero Número identificador del producto.
     */
    public Producto(int numero) {
        this.numero = numero;
    }

    // Getter y Setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método abstracto para mostrar la información del producto.
     * Cada subclase debe implementarlo.
     * @return Información del producto como String.
     */
    public abstract String mostrarInformacion();
}
