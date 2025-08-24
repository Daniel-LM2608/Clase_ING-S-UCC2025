import java.util.Arrays;

public class EjecutarEstu {

    public static void main(String[] args) {
        
        Estudiantev2 objEst1 = new Estudiantev2(18, "Yeisson", "Guevara", "Ingenieria" );
        Estudiantev2 objEst2 = new Estudiantev2(23, "Santiago", "Riveros","Ingenieria");
        Estudiantev2 objEst3 = new Estudiantev2(20, "Daniel", "Moncayo", "Ingenieria");

        System.out.println(objEst1); // toString
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println("---------------");
        //crear arreglo de objetos
        // in[] a = new int[5]
        Estudiantev2[] est = new Estudiantev2[5];

        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;


        //FORMA2

        est[3] = new Estudiantev2(506070, "Byron", "Beltran", "Psicologia");
        est[4] = new Estudiantev2(304050, "Antonio", "Biutrago", "Derecho");

        System.out.println(Arrays.toString(est));

        System.out.println("-----------------");

        for (Estudiantev2 estudiantev2 : est) {
            System.out.println(estudiantev2);
            
        }
        
        System.out.println("-----------------");
  // Matricular cursos
        objEst1.matricularCursos(18, new String[]{"Matemáticas", "Física"});
        objEst2.matricularCursos(23, new String[]{"Matemáticas", "Programación"});
        objEst3.matricularCursos(20, new String[]{"Programación"});
        est[3].matricularCursos(506070, new String[]{"Psicología", "Filosofía"});
        est[4].matricularCursos(304050, new String[]{"Derecho"});

        System.out.println("---------------");
        Estudiantev2.contarEstudiantesPorFacultad(est);

        System.out.println("---------------");
        Estudiantev2.contarEstudiantesPorCurso(est);
    }
}
