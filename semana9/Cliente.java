/**
 * Clase Cliente
 * Representa a un cliente con cédula y nombre.
 */
public class Cliente {
    // Atributos privados
    private String cedula;
    private String nombre;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param cedula Identificación del cliente.
     * @param nombre Nombre del cliente.
     */
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para mostrar la información del cliente.
     * 
     * @return Información del cliente como String.
     */
    public String mostrarInformacion() {
        return "Cliente [Cédula: " + cedula + ", Nombre: " + nombre + "]";
    }
}
