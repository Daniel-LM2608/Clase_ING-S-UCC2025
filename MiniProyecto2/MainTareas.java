public class MainTareas {
    
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        gestor.agregarTarea(new tarea("2608", "Reporte semanal", 1, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("0709", "Actualizacion de sistemas", 3, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("2703", "Notificacion de reportes", 2, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("0308", "Reporte de insidentes", 3, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("2005", "Notificaciones de personal", 1, System.currentTimeMillis()));
        gestor.agregarTarea(new tarea("0709", "Actualizacion de empleados", 2, System.currentTimeMillis()));

        System.out.println("Procesando Tareas");

        tarea procesada1 = gestor.procesarSiguienteTarea();
        if(procesada1 != null){
            System.out.println("Procesada:" + procesada1.getDescripcion());
        }

        tarea procesada2 = gestor.procesarSiguienteTarea();
        if(procesada2 != null){
            System.out.println("Procesada:" + procesada2.getDescripcion());
        }

        tarea procesada3= gestor.procesarSiguienteTarea();
        if(procesada3 != null){
            System.out.println("Procesada:" + procesada3.getDescripcion());
        }

         System.out.println("Registro de trazabilidad");
        gestor.mostrarTrazabilidad();
    }
}

    

