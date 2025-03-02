import java.util.Arrays;

public class Ejercicio7 {
    public static void main(String[] args) {
        int tam = 10;
        int[] A = new int[tam];

        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * (30 - 10)) + 10;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print("|" + A[i]);
        }
    
            System.out.println();
        
        int numeropares = 0;
        int numeroimpares = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                numeropares++;
            } else {
                numeroimpares++;
            }

        }

        int[] pares = new int[numeropares];
        int[] impares = new int[numeroimpares];

        int j = 0, k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                pares[j] = A[i];
                j++;
            } else {
                impares[k] = A[i];
                k++;

            }
        }

        System.out.println(Arrays.toString(pares));
        System.out.println(Arrays.toString(impares));
    }
}
