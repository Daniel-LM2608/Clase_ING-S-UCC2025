public class Arreglos {

    public static void main(String[] args) {
        /*
         * primera forma de declarar un arreglo:
         * 
         *
         *
         *
         * El numero hace referencia al tamaño del arreglo
         * tendremos que llenar el arrreglo.
         */

        int[] a = { 8, 3, 10, 22, 1, 9 };

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        // ------------------------

        int tam = 10;
        int[] b = new int[tam];

        // Estructura para llenar el arreglo, con numeros aleatoreos
        // entre 10 y 30
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * (30 - 10)) + 10;
        }

        // mostrar los elementos del arreglo
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }

    }
}
