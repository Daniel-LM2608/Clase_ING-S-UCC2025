import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("por favor digite la cantidad de viviendas: ");
        int n = leer.nextInt();

        int[] alquileres = new int[n];

        for (int i = 0; i < alquileres.length; i++) {
            alquileres[i] = (int) (Math.random() * (1000 + 100)) + 100;
        }
        int[] porcentaje = new int[n];
        for (int i = 0; i < porcentaje.length; i++) {
            porcentaje[i] = (int) (Math.random() * (100 + 1)) + 1;
        }
        int[] ganancia = new int[alquileres.length];

        for (int i = 0; i < ganancia.length; i++) {
            ganancia[i] = alquileres[i] * porcentaje[i] / 100;
        }

        for (int i = 0; i < alquileres.length; i++) {
            System.out.println("alquileres[" + i + "]=" + alquileres[i]);
        }
        for (int i = 0; i < porcentaje.length; i++) {
            System.out.println("porcentajes[" + i + "]=" + porcentaje[i]);
        }
        for (int i = 0; i < ganancia.length; i++) {
            System.out.println("ganacia de la vivienda[" + i + "]=" + ganancia[i]);
        }
    }
}
