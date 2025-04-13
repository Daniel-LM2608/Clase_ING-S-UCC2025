public class PrecioTotal {
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;
    private Equipaje[] equipaje;

    public PrecioTotal(Equipaje[] equipaje) {
        this.equipaje = equipaje;
    }

    public void calcularTotales() {
        totalPrecios = 0;
        totalBodega = 0;
        totalCabina = 0;

        for (Equipaje e : equipaje) {
            double precio = e.calcularPrecio();
            totalPrecios += precio;

            if (e instanceof Bodega) {
                totalBodega += precio;
            } else if (e instanceof Cabina) {
                totalCabina += precio;
            }
        }
    }

    public void mostrarTotales() {
        calcularTotales();
        System.out.println("Total Equipaje " + totalPrecios);
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);
    }
}

    // Métodos
    //e es un objeto del arreglo  que me sirve para no tener que mensionar el objeto como tal 
    // se usa for each Es una forma simple de recorrer todos los elementos de un arreglo o colección, sin usar índices.

    
