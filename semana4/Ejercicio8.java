public class Ejercicio8 {
    public static void main(String[] args) {
        int tam = 30;
        int[] n = new int[tam];

        for (int i = 0; i < n.length; i++) {
            n[i] = (int) (Math.random() * (100 - 1)) + 1;
        }

        for (int i = 0; i < n.length; i++) {
            System.out.print("|" + n[i]);
        }

        int mayor = n[0], menor = n[0];
        int mayorRepetido = 0, menorRepetido = 0;

        for(int num : n) {
            if (num > mayor) {
                mayor = num;

            }
            if (num < menor) {
                menor = num;
            }
        }

        for (int num : n) {
            if (num == mayor) mayorRepetido++;
            if (num == menor) menorRepetido++;
        }
        
        System.out.println(" el numero mayor es:" + mayor + " y se repite:" + mayorRepetido + " ves");
        System.out.println(" el numero menor es:" + menor + " y se repite:" + menorRepetido + " ves");



    }
}
