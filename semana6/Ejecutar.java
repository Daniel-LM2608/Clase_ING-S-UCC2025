public class Ejecutar {

    public static void main(String[] args) {

        // Instanciar el onjeto (creacion)
        Estudiante obEst1 = new Estudiante(1, "Daniel", "Moncayo", 19, "Ingenieria");
        Estudiante obEst2 = new Estudiante(2, "Santiago", "Callejas", 22, "Fisioterapia");

        System.out.println(obEst1); // toString
        System.out.println(obEst2);

        // Modificar la edad de estudiante
        obEst1.setEdad(20);

        System.out.println(obEst1);

    }
}