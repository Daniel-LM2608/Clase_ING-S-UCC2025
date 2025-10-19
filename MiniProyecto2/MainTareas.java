import java.util.Scanner;

public class MainTareas {
    
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        gestor.agregarTarea(new tarea("2608", "Reporte semanal", 1, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("0709", "Actualizacion de sistemas", 3, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("2703", "Notificacion de reportes", 2, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("0308", "Reporte de insidentes", 3, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("2005", "Notificaciones de personal", 1, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("2003", "Actualizacion de empleados", 2, System.currentTimeMillis()));
        
        System.out.println("Procesando Tareas");

        // Procesar solo 4 tareas
        for (int i = 0; i < 4; i++) {
            tarea procesada= gestor.procesarSiguienteTarea();
            if (procesada != null) {
                System.out.println("Procesada: " + procesada.getId() + " - " + procesada.getDescripcion());
            } else {
                System.out.println("No hay más tareas por procesar.");
                break;
            }
        }
        System.out.println("Registro de trazabilidad:");
        gestor.mostrarTrazabilidad();

        // 🔹 Consulta de estado por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Consulta de estado de tareas");
        System.out.print("Ingresa el ID de la tarea: ");
        String id = sc.nextLine(); // Lee el ID que escribe el usuario

        // Llamar al método de búsqueda
        String estado = gestor.consultarEstadoTarea(id);
        System.out.println("Resultado: " + estado);

        sc.close(); 
    }
}


    

