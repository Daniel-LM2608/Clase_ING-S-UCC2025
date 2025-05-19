import java.util.Scanner;

public class Vegeta extends Personaje {
    private static final int FUERZA = 7; // Más fuerza que Goku
    private static final int RESISTENCIA = 25; // Resistencia diferente

    public Vegeta(String nombre) {
        super(nombre, RESISTENCIA);
    }

    @Override
    public void atacar(Personaje oponente) {
        String poderElegido = elegirPoder();
        int danoBase = calcularDanoBase();
        int danoTotal = danoBase + FUERZA;

        if (poderElegido.equals("Big Bang Attack")) {
            danoTotal *= 3;
            System.out.println(getNombre() + " lanza Big Bang Attack!");
        } else if (poderElegido.equals("Final Flash")) {
            danoTotal *= 8;
            System.out.println(getNombre() + " ejecuta Final Flash!");
        }

        oponente.recibirDano(danoTotal);
        System.out.println(getNombre() + " ataca causando " + danoTotal + " puntos de daño.");
    }

    private String elegirPoder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un poder:");
        System.out.println("1. Big Bang Attack (daño x3)");
        System.out.println("2. Final Flash (daño x8)");
        System.out.print("Ingresa el número de la opción: ");

        int opcion = scanner.nextInt();
        String poderElegido = "";

        switch (opcion) {
            case 1:
                poderElegido = "Big Bang Attack";
                break;
            case 2:
                poderElegido = "Final Flash";
                break;
            default:
                System.out.println("Opción no válida. Se elegirá Big Bang Attack por defecto.");
                poderElegido = "Big Bang Attack";
        }

        return poderElegido;
    }

    public int getFuerza() {
        return FUERZA;
    }
}
