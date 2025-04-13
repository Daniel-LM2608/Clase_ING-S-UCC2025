public class Main {
    public static void main(String[] args) {
        // Crear algunos equipajes
        Cabina cabina1 = new Cabina(5, 3, 1000);     // Cabina con peso 5, tamaño 3 y precioBase 1000
        Bodega bodega1 = new Bodega(10, 2, 1500);    // Bodega con peso 10, tamaño 2 y precioBase 1500
        Cabina cabina2 = new Cabina(4, 2.5, 1000);   // Cabina con peso 4, tamaño 2.5 y precioBase 1000
        Bodega bodega2 = new Bodega(8, 3, 1200);     // Bodega con peso 8, tamaño 3 y precioBase 1200

        // Arreglo de tipo Equipaje
        Equipaje[] equipajes = { cabina1, bodega1, cabina2, bodega2 };

        // Crear objeto PrecioTotal
        PrecioTotal precios = new PrecioTotal(equipajes);

        // Mostrar totales
        precios.mostrarTotales();
    }
}

