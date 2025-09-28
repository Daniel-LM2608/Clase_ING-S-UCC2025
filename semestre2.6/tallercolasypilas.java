import java.util.Stack;

public class tallercolasypilas {

    public static void main(String[] args) {
        
         Stack<Integer> upvotes = new Stack<>();
        Stack<Integer> downvotes = new Stack<>();

        upvotes.push(13);
        upvotes.push(2);
        upvotes.push(132);
        downvotes.push(0);
        downvotes.push(33);
        downvotes.push(132);

        int tamano = upvotes.size();
        
        for (int i = 0; i < tamano; i++) {
            int up = upvotes.pop();
            int down = downvotes.pop();
            int resultado = up - down;
            System.out.println("votos" + resultado);
        }
        
    }

}
