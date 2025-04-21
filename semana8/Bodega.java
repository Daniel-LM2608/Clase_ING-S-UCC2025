public class Bodega extends Equipaje {
    private static final double CAPACIDAD = 8.0; // define variable constante 

    public Bodega(double peso, double tamanio) { // constructor crea objeto tipo bodega
        super(peso, tamanio); //lama al constructor de la clase padre, que en este caso es la clase Equipaje.
    }

    public Bodega(double precioBase) {
        super(precioBase); //lama al constructor de la clase padre, que resive solo el precio base
    }
    

    public Bodega() {
        super(); // el super usa los valores por defecto en equipaje 
    }

    @Override // Verifica y marca un método como sobrescrito 
    //Evita errores y mejora la claridad del código no es obligatorio pero recomendable
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamanio() * CAPACIDAD);
    }
}
