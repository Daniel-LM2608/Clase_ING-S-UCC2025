import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;

public class pilasvector {
    public static void main(String[] args) {
        
         // Crear Vector
        Vector<String> v = new Vector<>();

        // add(): agrega un elemento al final
        v.add("A");
        v.add("B");

        // addElement(): equivalente a add, agrega al final
        v.addElement("C");
        System.out.println("Inicial: " + v);

        // add(index, elem): inserta en una posición específica
        v.add(1, "X");
        System.out.println("add(index, elem): " + v);

        // addAll(): agrega todos los elementos de otra colección
        Vector<String> v2 = new Vector<>();
        v2.add("D");
        v2.add("E");
        v.addAll(v2);
        System.out.println("addAll: " + v);

        // addAll(index, coll): inserta colección en posición dada
        Vector<String> v3 = new Vector<>();
        v3.add("F");
        v3.add("G");
        v.addAll(2, v3);
        System.out.println("addAll(index, coll): " + v);

        // capacity(): devuelve la capacidad actual del vector
        System.out.println("Capacidad: " + v.capacity());

        // clone(): clona el vector
        Object copia = v.clone();
        System.out.println("Clonado: " + copia);

        // contains(): pregunta si existe un elemento
        System.out.println("¿Contiene B?: " + v.contains("B"));

        // containsAll(): pregunta si contiene todos los de otra colección
        System.out.println("¿Contiene v2?: " + v.containsAll(v2));

        // copyInto(): copia los elementos en un arreglo existente
        String[] arr = new String[v.size()];
        v.copyInto(arr);
        System.out.println("Copiado en arreglo: " + Arrays.toString(arr));

        // elementAt(): obtiene el elemento en la posición indicada
        System.out.println("elementAt(2): " + v.elementAt(2));

        // elements(): devuelve una enumeración de todos los elementos
        Enumeration<String> e = v.elements();
        System.out.print("elements(): ");
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        // ensureCapacity(): fuerza una capacidad mínima
        v.ensureCapacity(50);
        System.out.println("Capacidad después de ensureCapacity: " + v.capacity());

        // equals(): compara con otro vector
        System.out.println("equals copia: " + v.equals(copia));

        // firstElement() y lastElement(): obtiene primero y último
        System.out.println("firstElement: " + v.firstElement());
        System.out.println("lastElement: " + v.lastElement());

        // forEach(): recorre los elementos con un consumidor (lambda)
        System.out.print("forEach: ");
        v.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // get(): obtiene por índice
        System.out.println("get(3): " + v.get(3));

        // hashCode(): obtiene un código hash del vector
        System.out.println("hashCode: " + v.hashCode());

        // indexOf(): busca el índice de un elemento
        System.out.println("indexOf('B'): " + v.indexOf("B"));
        System.out.println("indexOf('B', 2): " + v.indexOf("B", 2));

        // insertElementAt(): inserta en una posición
        v.insertElementAt("Z", 1);
        System.out.println("insertElementAt: " + v);

        // isEmpty(): pregunta si el vector está vacío
        System.out.println("isEmpty: " + v.isEmpty());

        // iterator(): recorre los elementos
        Iterator<String> it = v.iterator();
        System.out.print("iterator: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // lastIndexOf(): busca última ocurrencia
        v.add("A"); // duplicado
        System.out.println("lastIndexOf('A'): " + v.lastIndexOf("A"));
        System.out.println("lastIndexOf('A', 2): " + v.lastIndexOf("A", 2));

        // listIterator(): iterador más completo (permite moverse hacia atrás/adelante)
        ListIterator<String> li = v.listIterator();
        System.out.print("listIterator: ");
        while (li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println();

        // remove(Object): elimina un elemento
        v.remove("X");
        System.out.println("remove(obj): " + v);

        // remove(index): elimina por índice
        v.remove(0);
        System.out.println("remove(index): " + v);

        // removeAll(): elimina todos los que estén en otra colección
        v.removeAll(v2);
        System.out.println("removeAll: " + v);

        // removeAllElements(): elimina todo el vector
        v.removeAllElements();
        System.out.println("removeAllElements: " + v);

        // rellenar de nuevo para continuar
        v.add("H");
        v.add("I");
        v.add("J");

        // removeElement(): elimina primera ocurrencia
        v.removeElement("I");
        System.out.println("removeElement: " + v);

        // removeElementAt(): elimina en una posición
        v.removeElementAt(0);
        System.out.println("removeElementAt: " + v);

        // removeIf(): elimina según condición (lambda)
        v.add("K");
        v.add("L");
        v.removeIf(x -> x.equals("L"));
        System.out.println("removeIf: " + v);

        // set(): reemplaza elemento en índice
        v.set(0, "Nuevo");
        System.out.println("set: " + v);

        // setElementAt(): reemplaza elemento en índice
        v.setElementAt("Otro", 1);
        System.out.println("setElementAt: " + v);

        // setSize(): cambia el tamaño (rellena con null si es mayor)
        v.setSize(5);
        System.out.println("setSize(5): " + v);

        // size(): cantidad de elementos
        System.out.println("size: " + v.size());

        // sort(): ordena según un comparador
        v.set(0, "C");
        v.set(1, "A");
        v.set(2, "B");
        v.sort(Comparator.naturalOrder());
        System.out.println("sort: " + v);

        // spliterator(): recorrido paralelo/funcional
        Spliterator<String> sp = v.spliterator();
        System.out.print("spliterator: ");
        sp.forEachRemaining(System.out::print);
        System.out.println();

        // subList(): obtiene una vista parcial de la lista
        List<String> sub = v.subList(0, 2);
        System.out.println("subList(0,2): " + sub);

        // toArray(): convierte a arreglo
        Object[] objArr = v.toArray();
        System.out.println("toArray: " + Arrays.toString(objArr));
        String[] strArr = v.toArray(new String[0]);
        System.out.println("toArray(T[]): " + Arrays.toString(strArr));

        // toString(): convierte a cadena
        System.out.println("toString: " + v.toString());

        // trimToSize(): reduce la capacidad al tamaño actual
        v.trimToSize();
        System.out.println("Capacidad después de trimToSize: " + v.capacity());

        // clear(): elimina todos los elementos
        v.clear();
        System.out.println("clear(): " + v);
    }
}
    

