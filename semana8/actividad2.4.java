public class Cabina extends Equipaje {
    // Constantes
    private final static int TIEMPO = 2;
    // Constructores
   public Cabina(double peso, double tamanio, double precioFinal) {
    //super para heredar de equipaje sin tener que repetirlo y reutilizar codigo
    super(peso, tamanio, 1000);//llamar constructor de equipaje con precio de 1000
   }
    // Metodos
    public double calcularPrecio(){
        double precioFinal = getPrecioBase() + (getPeso() * getTamamio() * TIEMPO);
    // Calculos
    return precioFinal;
    }

    public String mostrarInformacion() {
        return "Equipaje de Cabina/n"
    }


    // getters/setters de ser necesarios
   }
   // Fin de la solución