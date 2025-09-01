public class EjecutarMatrices {
    
    public static void main(String[] args) {
        
        MatricesEstructuraDeDatos objMatrices = new MatricesEstructuraDeDatos();

        int[][] m = objMatrices.llenarMatrizEnteros(7, 7);

        System.out.println(objMatrices.mostrarMatrizEnteros(m));
    }
}
