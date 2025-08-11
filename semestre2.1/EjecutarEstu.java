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
        Estudiantev2[] est = new Estudiantev2[3];

        est[0] = objEst1;
        est[2] = objEst2;
        est[3] = objEst3;

        System.out.println(Arrays.toString(est));
    }
}