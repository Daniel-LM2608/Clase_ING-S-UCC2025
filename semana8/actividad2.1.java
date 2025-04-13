public class PrecioTotal {
    // Atributos
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;
    private Equipaje[] equipaje;

    // Constructor
    public PrecioTotal(Equipaje[] equipaje) {
        this.equipaje = equipaje;
    }

    // Métodos
    //e es un objeto del arreglo  que me sirve para no tener que mensionar el objeto como tal 
    // se usa for each Es una forma simple de recorrer todos los elementos de un arreglo o colección, sin usar índices.

    public void calcularTotales() {
        for (Equipaje e : equipaje) {
            double precio = e.calcularPrecio();
            totalPrecios += precio;

            if (e instanceof Cabina) {
                totalCabina += precio;
            } else if (e instanceof Bodega) {
                totalBodega += precio;
            }
        }
    }

    public void mostrarTotales() {
        // Calculo de totales
        calcularTotales();
        System.out.println("Total Equipaje " + totalPrecios);
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);
    }
}
