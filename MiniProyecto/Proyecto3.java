package MiniProyecto;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Proyecto3 {

    public static void main(String[] args) {
        int tam = 40;
        boolean[] ocupado = new boolean[tam]; // para saber si esta libre false o ocupado true
        String[] destinatario = new String[tam]; // para guardas las placas moto en los puestos
        LocalDateTime[] fechaIngreso = new LocalDateTime[tam]; //para guardar la hora en el puesto 
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();//generar numeros aleatorios

        while (true) { // me sirve para hacer un bucle para poder regristrar motos y tambien para salir
                       // del bucle
            // para mostrar los puestos disponibles
            System.out.println("Estado del casillero");
            for (int i = 0; i < tam; i++) {
                if (ocupado[i]) { // si el puesto esta ocupado
                    System.out.print("[X]");

                } else { // si el puesto esta libre
                    System.out.print("[" + i + "]");
                }
            }
            System.out.println();
    }
    
}
