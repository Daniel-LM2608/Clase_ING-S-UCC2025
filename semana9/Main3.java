import java.util.Date;

public class Main3 {
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente("123456789", "Juan Pérez");

        // Crear fotos
        Foto foto1 = new Foto("foto1.jpg");
        Foto foto2 = new Foto("foto2.jpg");
        Foto[] fotos = { foto1, foto2 };

        // Crear un producto tipo Impresion
        Impresion impresion = new Impresion(1, "Color", fotos);

        // Crear un producto tipo Camara
        Camara camara = new Camara(2, "Canon", "EOS 90D");

        // Crear un arreglo de productos
        Producto[] productos = { impresion, camara };

        // Crear un pedido
        Pedido pedido = new Pedido(cliente, productos, new Date(), 12345678);

        // Mostrar la información del pedido
        System.out.println(pedido.mostrarInformacion());

        // Extra: imprimir las fotos de la impresión
        System.out.println("\nImprimiendo fotos de la impresión:");
        for (Foto foto : impresion.getFotos()) {
            foto.print();
        }
    }
}
