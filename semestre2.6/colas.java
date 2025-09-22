import java.util.ArrayDeque;
import java.util.Queue;

public class colas {

    public static void main(String[] args) {
        
        Queue<Integer> cola = new ArrayDeque<>();

        System.out.println(cola.peek());

        cola.add(5);
        cola.add(10);
        cola.add(3);
        cola.add(20);

        System.out.println(cola);

        System.out.println(cola.element());

        System.out.println(cola);

        
        System.out.println(cola.remove(10));

        System.out.println(cola);


        System.out.println(cola.offer(10));

        System.out.println(cola);

        System.out.println(cola.poll());

        System.out.println(cola);

        System.out.println(cola.remove(20));

        System.out.println(cola);





          
    }
}