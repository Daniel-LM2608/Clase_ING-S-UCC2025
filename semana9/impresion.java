import java.util.Arrays;

/**
 * Clase Impresion
 * Representa un producto de tipo impresión que contiene varias fotos.
 */
public class Impresion extends Producto {
    // Atributos privados
    private String color;
    private Foto[] fotos; // Composición: Impresion contiene varias Fotos

    /**
     * Constructor de la clase Impresion.
     * 
     * @param numero Número identificador del producto (heredado).
     * @param color  Color de la impresión.
     * @param fotos  Arreglo de fotos a imprimir.
     */
    public Impresion(int numero, String color, Foto[] fotos) {
        super(numero); // Llamada al constructor de Producto
        this.color = color;
        this.fotos = fotos;
    }

    // Getters y Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Foto[] getFotos() {
        return fotos;
    }

    public void setFotos(Foto[] fotos) {
        this.fotos = fotos;
    }

    /**
     * Implementación del método abstracto mostrarInformacion().
     * 
     * @return Información detallada de la impresión.
     */
    @Override
    public String mostrarInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Impresión [Número: ").append(getNumero())
                .append(", Color: ").append(color)
                .append(", Fotos: ");

        if (fotos != null && fotos.length > 0) {
            for (Foto foto : fotos) {
                sb.append(foto.getFichero()).append(" ");
            }
        } else {
            sb.append("No hay fotos");
        }

        sb.append("]");
        return sb.toString();
    }
}
