import java.util.Stack;

public class pilasColas {

    public static void main(String[] args) {
        //pilas en java stack

        Stack<Integer> pila = new Stack<>();

        System.out.println("La pila esta vacia ? " + pila.empty());

        pila.push(10);
        pila.push(20);
        pila.push(5);
        pila.push(9);
        pila.push(35);

        System.out.println("la pila esta vacia? " + pila.empty());

        System.out.println(pila);

        System.out.println(pila.peek());

        pila.pop();

        System.out.println(pila.peek());
        
        System.out.println(pila);


        System.out.println(pila.search(9));
        System.out.println(pila.search(5));
        System.out.println(pila.search(20));
        System.out.println(pila.search(10));

        System.out.println(pila.search(50));




    }
}