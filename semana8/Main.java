public class Main {
    public static void main(String[] args) {
        // Crear algunos equipajes
        Cabina cabina1 = new Cabina(5, 3, 0);      // Cabina con peso 5 y tamaño 3
        Bodega bodega1 = new Bodega(10, 2, 1500);  // Bodega con peso 10, tamaño 2 y precio base 1500
        Cabina cabina2 = new Cabina(4, 2.5, 0);    // Cabina con peso 4 y tamaño 2.5
        Bodega bodega2 = new Bodega(8, 3, 1200);   // Bodega con peso 8, tamaño 3 y precio base 1200

        // Arreglo de tipo Equipaje
        Equipaje[] equipajes = { cabina1, bodega1, cabina2, bodega2 };

        // Crear objeto PrecioTotal
        PrecioTotal precios = new PrecioTotal(equipajes);

        // Mostrar totales
        precios.mostrarTotales();
    }
}

