import java.util.Random;

public class OperacionesArreglos {

    // metodo para llenar un arreglo de enteros
    public int[] llenarArregloEnteros(int tam) {

        Random rand = new Random();

        int[] numeros = new int[tam];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100 - 1) + 1; // numeros del 1 al 100

        }

        // Sumar los elementos de un arreglo de enteros
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }

        System.out.println("La suma de los elementos del arreglo es:" + suma);

        // Obtener el promedio de un arreglo de enteros
        double promedio = 0;
        for (int i = 0; i < numeros.length; i++) {
            promedio = promedio + (double) numeros[i] / 5; // convertir el a decimal antes de dividr

        }

        System.out.println("El promedio de los elementos del arreglo es:" + promedio);

        // Obtener el mayor y el menor de un arreglo de enteros
        int mayor = numeros[0], menor = numeros[0];

        for (int num : numeros) {
            if (num > mayor) {
                mayor = num;
            }
            if (num < menor) {
                menor = num;
            }

        }

        System.out.println(" el numero mayor es:" + mayor);
        System.out.println(" el numero menor es:" + menor);

        return numeros;

        // Obtener los numeros repetidos de un arreglo de enteros

    }

}
