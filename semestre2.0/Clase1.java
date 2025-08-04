import java.util.Arrays;

public class Clase1 {
    public static void main(String[] args) {
        
        System.out.println("Estructura de datos");

        //Arreglos o arrays o vectores
        
        //Declaracion del arreglo. forma1
        //int[] numeros;
        //numeros = new int[5];

        //Declaracion del arreglo. forma2
        //int[] numeros = new int[5];

        //Declaracion e inicializacion 
        //int[] numeros = {10, 20, 30, 40, 50};

        OperacionesArreglos objArreglos = new OperacionesArreglos();

        int[] numeros = objArreglos.llenarArregloEnteros(5);

        System.out.println(Arrays.toString(numeros));
    }
    
}
