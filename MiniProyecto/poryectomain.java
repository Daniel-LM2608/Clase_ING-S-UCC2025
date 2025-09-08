package MiniProyecto;

import java.util.Scanner;

public class poryectomain {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear casilleros: 20 pequeños, 15 medianos, 5 grandes
        casillero[] casilleros = new casillero[40];
        for (int i = 0; i < casilleros.length; i++) {
            if (i < 20) casilleros[i] = new casillero(i, "pequeño");
            else if (i < 35) casilleros[i] = new casillero(i, "mediano");
            else casilleros[i] = new casillero(i, "grande");
        }

        while (true) {
            // Mostrar casilleros visualmente
            System.out.println("\n ESTADO DE LOS CASILLEROS ");
            for (int i = 0; i < casilleros.length; i++) {
                if (casilleros[i].isOcupado()) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[" + casilleros[i].getId() + "]");
                }
                if ((i + 1) % 10 == 0) System.out.println();
            }

            // Menú principal
            System.out.println("\n MENÚ CASILLEROS ");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Ver información de casilleros");
            System.out.println("4. Liberar casillero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                // Registrar paquete
                System.out.print("Ingrese el nombre del destinatario: ");
                String destinatario = scanner.nextLine();
                System.out.print("Ingrese tamaño del paquete (pequeño/mediano/grande): ");
                String tamano = scanner.nextLine();

                System.out.print("Seleccione el número de casillero (0 - 39): ");
                int numCasillero = scanner.nextInt();
                scanner.nextLine();

                if (numCasillero >= 0 && numCasillero < casilleros.length) {
                    casillero c = casilleros[numCasillero];
                    if (c.disponible()) {
                        if (c.tamanoCorrecto(tamano)) {
                            c.asignarPaquete(new paquete(destinatario, tamano));
                        } else {
                            System.out.println(" Ese casillero no es del tamaño correcto (" + c.getTamano() + ")");
                        }
                    } else {
                        System.out.println(" Ese casillero está ocupado.");
                    }
                } else {
                    System.out.println(" Número de casillero inválido.");
                }

            } else if (opcion == 2) {
                // Mostrar casilleros libres
                System.out.println("\n CASILLEROS DISPONIBLES ");
                for (casillero c : casilleros) {
                    if (c.disponible()) {
                        System.out.println("Casillero " + c.getId() + " (" + c.getTamano() + ")");
                    }
                }

            } else if (opcion == 3) {
                // Información de todos los casilleros
                System.out.println("\n INFORMACIÓN CASILLEROS");
                for (casillero c : casilleros) {
                    System.out.println(c.getInfo());
                }

            } else if (opcion == 4) {
                // Liberar casillero
                System.out.print("Ingrese el número de casillero que desea vaciar : ");
                int numCasillero = scanner.nextInt();
                scanner.nextLine();
                if (numCasillero >= 0 && numCasillero < casilleros.length) {
                    casilleros[numCasillero].vaciarCasillero();
                } else {
                    System.out.println(" Número de casillero inválido.");
                }

            } else if (opcion == 5) {
                System.out.println(" Cerrando aplicación...");
                break;

            } else {
                System.out.println(" Opción inválida.");
            }
        }

        scanner.close();
    }
}
