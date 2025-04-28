/**
 * Clase Camara
 * Representa un producto de tipo cámara.
 */
public class Camara extends Producto {
    // Atributos privados
    private String marca;
    private String modelo;

    /**
     * Constructor de la clase Camara.
     * @param numero Número identificador del producto (heredado).
     * @param marca Marca de la cámara.
     * @param modelo Modelo de la cámara.
     */
    public Camara(int numero, String marca, String modelo) {
        super(numero); // Llamada al constructor de Producto
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Implementación del método abstracto mostrarInformacion().
     * @return Información detallada de la cámara.
     */
    @Override
    public String mostrarInformacion() {
        return "Cámara [Número: " + getNumero() + 
               ", Marca: " + marca + 
               ", Modelo: " + modelo + "]";
    }
}
