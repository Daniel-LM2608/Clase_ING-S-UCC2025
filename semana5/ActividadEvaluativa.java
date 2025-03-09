import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class ActividadEvaluativa {

    public static void main(String[] args) {

        int tam = 21;
        boolean[] ocupado = new boolean[tam]; // para saber si esta libre false o ocupado true
        String[] placas = new String[tam]; // para guardas las placas moto en los puestos
        LocalTime[] tiempoEntrada = new LocalTime[tam]; //para guardar la hora en el puesto 
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();//generar numeros aleatorios
        


        while (true) { // me sirve para hacer un bucle para poder regristrar motos y tambien para salir
                       // del bucle
            // para mostrar los puestos disponibles
            System.out.println("Estado del parqueadero");
            for (int i = 0; i < tam; i++) {
                if (ocupado[i]) { // si el puesto esta ocupado
                    System.out.print("[X]");

                } else { // si el puesto esta libre
                    System.out.print("[" + i + "]");
                }
            }
            System.out.println();

            //menu de opciones 
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Registrar moto ");
            System.out.println("2. Pagar y dejar puesto");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();



            if (opcion == 1){
                //registrar moto
                System.out.println("Seleccione un puetso del o al 20 o (-0 para salir)");
                 int puesto = scanner.nextInt(); // para que eliga un puesto
                 scanner.nextLine();
                 
                 
                 if (puesto >= 0 && puesto < tam) { // para saber si el puesto exite
                    if (!ocupado[puesto]) { // para ver si el puesto esta libre o ocupado
                        System.out.print("Ingrese la placa");
                        placas[puesto] = scanner.nextLine();// para guardar la placa de la moto
                        ocupado[puesto] = true;
                        
                        //poner un tiempo aleatorio entre 10 y 120 minutos 
                        int minutosAleatorios = random.nextInt(111) + 10;
                        tiempoEntrada[puesto] = LocalTime.now().minusMinutes(minutosAleatorios);                        
                        
                        System.out.println("Moto registrada en el puesto " + puesto + " a las " + tiempoEntrada[puesto]);
                    } else {
                        System.out.println("El puesto esta ocupado, eliga otro puesto.");
                    }
                } else {
                    System.out.println("Numero de puesto invalido o no existe");
                }
            } else if (opcion == 2){
                //pagar y liberar puesto 
                System.out.print("ingrese el numero de puesto que quiere pagar (0-20): ");
                int puesto = scanner.nextInt();
                scanner.nextLine();
                
                if (puesto >= 0 && puesto < tam) {
                    if (ocupado[puesto] && tiempoEntrada[puesto] != null) { // para cobrar solo si hay un tiempo regristado
                        LocalTime tiempoSalida = LocalTime.now(); // sirve para guardar la hora de salida
                        long tiempoTotal = Duration.between(tiempoEntrada[puesto], tiempoSalida).toMinutes();// calcular los minutos
                        
                        int costo = 0;
                        if (tiempoTotal > 30 && tiempoTotal <= 60) {
                            costo = 800;
                        } else if (tiempoTotal > 60) {
                            costo = 2000;
                        }
                        
                        System.out.println("Puesto " + puesto + " - Placa: " + placas[puesto]);
                        System.out.println("tiempo; " + tiempoTotal + " minutos - Total a pagar: $" + costo);
                        System.out.println("Pago realizado. El puesto esta disponible.");

                        //vaciar puesto
                        ocupado[puesto] = false; // poner el puesto disponible
                        placas[puesto] = null;
                        tiempoEntrada[puesto] = null;

                    } else {
                        System.out.println("El pueesto ya esta libre o no tiene registro de tiempo.");
                    }
                } else {
                    System.out.println("Numero de puesto invalido.");
                }
            } else if (opcion == 3) {
                //salir
                System.out.println("Saliedno del programa...");
                break;
            } else {
                System.out.println("Opcion invalida.");
            }

            
        }
        scanner.close();
        
    }
}