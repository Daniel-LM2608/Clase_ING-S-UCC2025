import java.util.Scanner;

public class Goku extends Personaje {
    private static final int FUERZA = 5;
    private static final int RECISTENCIA = 20;
    
        
    public Goku(String nombre) {
            super(nombre,RECISTENCIA);
     }

     @Override
    public void atacar(Personaje oponente) {
        String poderElegido = elegirPoder();
        // Usamos el método calcularDanoBase() de Personaje para calcular el daño base
        int danoBase = calcularDanoBase();
        int danoTotal = danoBase + FUERZA;  // Se agrega la fuerza del Guerrero al daño base



        if (poderElegido.equals("Puño del Dragón")) {
            // El poder especial ahora siempre se activa
            danoTotal *= 10;  // Multiplicamos el daño por 2, por ejemplo
            System.out.println(getNombre() + " Realiza un Puño del Dragón");
        } else if (poderElegido.equals("Kame Hame Ha")) {
            // multiplicamos el daño total por 2
            danoTotal *= 4;
            System.out.println(getNombre() + " realiza el KAME HAME HA !!!");
        }

        oponente.recibirDano(danoTotal);
        System.out.println(getNombre() + " ataca con" + poderElegido + " causando " + danoTotal + " puntos de daño.");
    }

       // Método para que el jugador elija el poder
    private String elegirPoder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un poder:");
        System.out.println("1. Puño del Dragón (daño x10)");
        System.out.println("2. Kame Hame Ha (daño x4)");
        System.out.print("Ingresa el número de la opción: ");
        
        int opcion = scanner.nextInt();
        String poderElegido = "";

        switch (opcion) {
            case 1:
                poderElegido = "Puño del Dragón";
                break;
            case 2:
                poderElegido = "Kame Hame Ha";
                break;
            default:
                System.out.println("Opción no válida. Se elegiráKame Hame Ha por defecto.");
                poderElegido = "Kame Hame Ha";
        }

        return poderElegido;
    }

      public int getFuerza() {
        return FUERZA;
    }

}



     
    