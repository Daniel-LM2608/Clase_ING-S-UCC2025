public class Ejercicio2 {
    public static void main(String[] args) {
        //los arreglos denem ser del mismo tamaño
        //sueldos de los empleados
        double[] A = {1000.0, 1350.0, 900.0 };
        //Asignaciones totales de cada empleado
        double[] B = { 100.0, 230.0, 150.0 };
        //Deducciones de cada empleado
        double[] C = { 20.0, 35.0, 10.0 };

        //arreglo que almacena el neto a pagar de cada empleado ej A.length  3
        double[] T = new double[A.length];
        //Asignacion de la formula  a cada posicion del arreglo T
        for(int i = 0; i < T.length; i++){
            T[i] = A[i] + B[i] - C[i];
        }
        //Mostrar el neto a pagar de los elementos
        for (int i = 0; i < T.length; i++) {
            System.out.println("T[" + i + "]=" + T[i]);
        }
    }
}
