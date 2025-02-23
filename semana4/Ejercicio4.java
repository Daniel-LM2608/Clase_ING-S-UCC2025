public class Ejercicio4 {
    public static void main(String[] args) {
        int tam = 10;
        int[] b = new int[tam];

        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * (30 - 10)) + 10;
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }
    }
}
