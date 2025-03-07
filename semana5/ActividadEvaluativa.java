import java.util.Scanner;

public class ActividadEvaluativa {

    public static void main(String[] args) {

        int tam = 21;
        boolean[] ocupado = new boolean[tam]; // para saber si esta libre false o ocupado true
        String[] placas = new String[tam]; // para guardas las placas moto en los puestos
        Scanner scanner = new Scanner(System.in);


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
            System.out.println("Seleccione un puetso del o al 20 o (-0 para salir)");
            int puesto = scanner.nextInt(); // para que eliga un puesto
            scanner.nextLine();
            if (puesto == -0){
                System.out.println("Saliendo del programa");
                break;
            }
            if (puesto >= 0 && puesto < tam) { // para saber si el puesto exite
                if (!ocupado[puesto]) { // para ver si el puesto esta libre o ocupado
                    System.out.print("Ingrese la placa");
                    placas[puesto] = scanner.nextLine();// para guardar la placa de la moto
                    ocupado[puesto] = true;
                    System.out.println("Moto registrada en el puesto " + puesto);
                } else {
                    System.out.println("El puesto esta ocupado, eliga otro puesto.");
                }
            } else {
                System.out.println("Numero de puesto invalido o no existe");
            
            }
        }   

    }
}