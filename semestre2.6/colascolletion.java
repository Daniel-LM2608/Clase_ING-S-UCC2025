import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterator;

public class colascolletion {

    public static void main(String[] args) {
        
          // Creamos una cola con LinkedList
        Queue<String> cola = new LinkedList<>();

        // add(): agrega elementos a la cola
        cola.add("A");
        cola.add("B");
        cola.add("C");
        System.out.println("Cola inicial: " + cola);

        // addAll(): agrega todos los elementos de otra colección
        Queue<String> otraCola = new LinkedList<>();
        otraCola.add("D");
        otraCola.add("E");
        cola.addAll(otraCola);
        System.out.println("Después de addAll: " + cola);

        // contains(): pregunta si un elemento existe
        System.out.println("¿Contiene 'B'? " + cola.contains("B"));

        // containsAll(): pregunta si contiene todos los elementos de otra colección
        System.out.println("¿Contiene toda otraCola? " + cola.containsAll(otraCola));

        // equals(): compara si dos colas tienen los mismos elementos en el mismo orden
        Queue<String> copia = new LinkedList<>(cola);
        System.out.println("¿cola es igual a copia? " + cola.equals(copia));

        // hashCode(): devuelve un valor hash único según los elementos
        System.out.println("hashCode de cola: " + cola.hashCode());

        // isEmpty(): pregunta si está vacía
        System.out.println("¿Cola vacía?: " + cola.isEmpty());

        // iterator(): recorre los elementos
        System.out.print("iterator: ");
        Iterator<String> it = cola.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // parallelStream(): recorre en paralelo (útil para procesamiento masivo)
        System.out.print("parallelStream: ");
        cola.parallelStream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        // remove(Object): elimina un elemento
        cola.remove("B");
        System.out.println("Después de remove('B'): " + cola);

        // removeAll(): elimina todos los que estén en otra colección
        cola.removeAll(otraCola);
        System.out.println("Después de removeAll(otraCola): " + cola);

        // removeIf(): elimina según condición
        cola.removeIf(e -> e.equals("A"));
        System.out.println("Después de removeIf (==A): " + cola);

        // retainAll(): conserva solo los que estén en otra colección
        Queue<String> nuevaCola = new LinkedList<>();
        nuevaCola.add("C");
        nuevaCola.add("Z");
        cola.retainAll(nuevaCola);
        System.out.println("Después de retainAll(nuevaCola): " + cola);

        // size(): tamaño de la cola
        System.out.println("Tamaño de la cola: " + cola.size());

        // spliterator(): recorrido funcional
        System.out.print("spliterator: ");
        Spliterator<String> sp = cola.spliterator();
        sp.forEachRemaining(e -> System.out.print(e + " "));
        System.out.println();

        // stream(): recorrido secuencial
        System.out.print("stream: ");
        cola.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        // toArray(): convierte la cola en arreglo
        Object[] arr1 = cola.toArray();
        System.out.println("toArray(): " + Arrays.toString(arr1));

        // toArray(T[]): convierte en arreglo tipado
        String[] arr2 = cola.toArray(new String[0]);
        System.out.println("toArray(T[]): " + Arrays.toString(arr2));

        // clear(): elimina todos los elementos
        cola.clear();
        System.out.println("Después de clear(): " + cola);

    }
}
