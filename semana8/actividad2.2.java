public class Equipaje {
    // Constantes
    private static final double PESO = 10.0;
    private static final double TAMANIO = 4.5;
    private static final double PRECIO_BASE = 1000.0;
    // Atributos
    private double peso;
    private double tamanio;
    private double precioBase;
    // Constructores
    //por defecto
    public Equipaje() {
        this.peso = PESO;
        this.tamanio = TAMANIO;
        this.precioBase = PRECIO_BASE;
    }

    //con parametros 
    public Equipaje(double peso,double tamanio, double precioBase) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
    }

   
    // Metodos
    public double calcularPrecio(){
    return 0.0;
    }


    // getters/setters de ser necesarios
    //getters

    public double getPeso() {
        return peso;
    }

    public double getTamamio() {
        return tamanio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    //setters

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

