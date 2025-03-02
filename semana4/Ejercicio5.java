import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("por favor digite la cantidad de viviendas: ");
        int n = leer.nextInt();
        // int n = 5;
        int[] alquileres = new int[n];
        // Estructura para llenar el arreglo, con numeros aleatoreos
        // entre 10 y 30
        for (int i = 0; i < alquileres.length; i++) {
            alquileres[i] = (int) (Math.random() * (100 + 1000)) + 1000;
        }
        int[] porcentaje = new int[n];
        // Estructura para llenar el arreglo, con numeros aleatoreos
        // entre 10 y 30
        for (int i = 0; i < porcentaje.length; i++) {
            porcentaje[i] = (int) (Math.random() * (1 + 100)) + 100;
        }
        int[] ganancia = new int[n];

        for (int i = 0; i < ganancia.length; i++) {
            ganancia[i] = alquileres[i] * porcentaje[i] / 100;
        }
        // mostrar los elementos del arreglo
        for (int i = 0; i < ganancia.length; i++) {
            System.out.println("ganancias[" + i + "]=" + ganancia[i]);
        }

        System.out.println("La ganancia de las " + n + " viviendas son :" + ganancia);

        leer.close();
    }
}
