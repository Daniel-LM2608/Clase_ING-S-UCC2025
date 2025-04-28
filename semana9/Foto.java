/**
 * Clase Foto
 * Representa una foto con su nombre de fichero.
 */
public class Foto {
    // Atributo privado
    private String fichero;

    /**
     * Constructor de la clase Foto.
     * @param fichero Nombre del archivo de la foto.
     */
    public Foto(String fichero) {
        this.fichero = fichero;
    }

    // Getter y Setter
    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    /**
     * Método para simular la impresión de la foto.
     */
    public void print() {
        System.out.println("Imprimiendo la foto: " + fichero);
    }
}
