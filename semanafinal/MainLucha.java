import java.util.Scanner;

public class MainLucha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        Personaje jugador1 = elegirPersonaje(nombre1, scanner);

        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        Personaje jugador2 = elegirPersonaje(nombre2, scanner);

        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciarPelea();
    }

    private static Personaje elegirPersonaje(String nombreJugador, Scanner scanner) {
        System.out.println("Elige un personaje para " + nombreJugador + ":");
        System.out.println("1. Goku");
        System.out.println("2. Vegeta");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea pendiente

        switch (opcion) {
            case 1:
                return new Goku(nombreJugador);
            case 2:
                return new Vegeta(nombreJugador);
            default:
                System.out.println("Opción inválida. Se seleccionará Goku por defecto.");
                return new Goku(nombreJugador);
        }
    }
}


