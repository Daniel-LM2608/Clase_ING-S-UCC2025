public class PrecioTotal {
    private Equipaje[] equipajes;
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;

    public PrecioTotal(Equipaje[] equipajes) {
        this.equipajes = equipajes;
        calcularTotales();
    }

    public void calcularTotales() {
        totalPrecios = 0;
        totalBodega = 0;
        totalCabina = 0;

        for (Equipaje e : equipajes) {
            double precio = e.calcularPrecio();
            totalPrecios += precio;

            // Sumar precio según el tipo de equipaje
            if (e instanceof Bodega) {
                totalBodega += precio;
            } else if (e instanceof Cabina) {
                totalCabina += precio;
            }
        }

        // Depuración para ver el cálculo
        System.out.println("Total Equipaje Calculado: " + totalPrecios);
        System.out.println("Total Bodega Calculado: " + totalBodega);
        System.out.println("Total Cabina Calculado: " + totalCabina);
    }

    public void mostrarTotales() {
        System.out.println("Total Equipaje " + totalPrecios);
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);
    }
}

    // Métodos
    //e es un objeto del arreglo  que me sirve para no tener que mensionar el objeto como tal 
    // se usa for each Es una forma simple de recorrer todos los elementos de un arreglo o colección, sin usar índices.

    
