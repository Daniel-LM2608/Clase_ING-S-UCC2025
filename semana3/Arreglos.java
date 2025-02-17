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

        int[] a = { 8, 3, 10, 22, 1, 9};

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

    }
}