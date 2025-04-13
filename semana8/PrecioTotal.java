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
            totalPrecios += e.calcularPrecio(); // Suma el precio de cada equipaje
            if (e instanceof Bodega) {
                totalBodega += e.calcularPrecio(); // Solo suma para Bodega
            } else if (e instanceof Cabina) {
                totalCabina += e.calcularPrecio(); // Solo suma para Cabina
            }
        }
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

    
