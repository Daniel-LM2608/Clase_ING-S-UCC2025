import java.util.Random;

public class OperacionesArreglos {

    //metodo para llenar un arreglo de enteros
    public int[] llenarArregloEnteros(int tam){
        
        Random rand = new Random();

        int[] numeros = new int[tam];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = rand.nextInt(100 - 1) + 1; //numeros del 1 al 100

        }

         //Sumar los elementos de un arreglo de enteros
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma = suma + numeros[i];
        }

        System.out.println("La suma de los elementos del arreglo es:" + suma);

        return numeros;

    //Obtener el promedio de un arreglo de enteros

    //Obtener los numeros repetidos de un arreglo de enteros

    //Obtener el mayor y el menor de un arreglo de enteros


    }
    
}
