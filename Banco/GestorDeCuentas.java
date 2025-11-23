
// Importaciones necesarias para colecciones y lectura de datos desde consola
import java.util.ArrayList; // ArrayList: lista dinámica que puede crecer y permite acceso por índice
import java.util.LinkedList; // LinkedList: lista doblemente enlazada, usada aquí para implementar cola
import java.util.Queue; // Queue: interfaz para estructuras tipo FIFO (First In First Out)
import java.util.Scanner; // Scanner: permite leer datos del usuario desde la consola

public class GestorDeCuentas {

    // ----------------------- ATRIBUTOS PRINCIPALES -----------------------

    // Nodo raíz del BST (árbol binario de búsqueda) que organiza cuentas por ID
    private NodoBST raiz;

    // ----------------------- CLASE INTERNA: NODOBST -----------------------
    class NodoBST {
        Cuenta cuenta; // Cada nodo guarda una cuenta
        NodoBST izquierda; // Referencia al nodo hijo izquierdo (IDs menores)
        NodoBST derecha; // Referencia al nodo hijo derecho (IDs mayores)

        // Constructor del nodo
        public NodoBST(Cuenta cuenta) {
            this.cuenta = cuenta; // Asigna la cuenta al nodo
            // izquierda y derecha se inicializan automáticamente en null
        }
    }

    // Lista de todas las cuentas registradas en el sistema
    private ArrayList<Cuenta> cuentas;

    // Lista de todas las transacciones realizadas
    private ArrayList<Transaccion> transacciones;

    // Cola para demostrar uso de estructuras auxiliares
    // Aquí se guarda temporalmente las transacciones para procesarlas en orden
    private Queue<Transaccion> colaTransacciones;

    // Scanner para leer entradas del usuario desde consola
    private Scanner sc;

    // ----------------------- CONSTRUCTOR -----------------------
    public GestorDeCuentas() {
        cuentas = new ArrayList<>(); // Inicializa lista vacía de cuentas
        transacciones = new ArrayList<>(); // Inicializa lista vacía de transacciones
        colaTransacciones = new LinkedList<>(); // Inicializa la cola FIFO
        sc = new Scanner(System.in); // Inicializa el Scanner para leer datos del usuario
        raiz = null; // Inicializa el BST vacío
    }

    // ----------------------- MÉTODOS AUXILIARES -----------------------

    // Busca una cuenta por su ID recorriendo la lista
    public Cuenta buscarCuenta(int id) {
        for (Cuenta c : cuentas) { // Recorre cada elemento de la lista de cuentas
            if (c.getId() == id) // Compara el ID de la cuenta actual con el buscado
                return c; // Devuelve la cuenta si coincide
        }
        return null; // Devuelve null si no encontró la cuenta
    }

    // Verifica si un ID ya existe en la lista de cuentas
    private boolean idExiste(int id) {
        return buscarCuenta(id) != null; // true si la cuenta ya existe, false si no
    }

    // ----------------------- CREAR NUEVA CUENTA -----------------------

    public void crearCuenta() {
        try {
            // Se pide al usuario seleccionar el tipo de cuenta
            System.out.println("Seleccione tipo de cuenta:");
            System.out.println("1. Ahorro");
            System.out.println("2. Débito");
            System.out.println("3. Crédito");
            System.out.print("Opción: ");

            // Leemos la opción seleccionada como String, la convertimos a int
            // trim() elimina espacios al inicio y final
            int opc = Integer.parseInt(sc.nextLine().trim());

            // Solicitamos el ID de la nueva cuenta
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Validación: si el ID ya existe, se cancela la creación
            if (idExiste(id)) {
                System.out.println("Ese ID ya existe. Cancelando creación.");
                return; // Sale del método
            }

            // Solicitamos el monto de apertura
            System.out.print("Monto de apertura (>=0): ");
            double apertura = Double.parseDouble(sc.nextLine().trim());

            // Validación: monto no puede ser negativo
            if (apertura < 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Creamos un objeto Cuenta según el tipo seleccionado
            Cuenta nueva = null;
            switch (opc) {
                case 1:
                    nueva = new Ahorro(id, apertura); // Cuenta de ahorro
                    break;
                case 2:
                    nueva = new Debito(id, apertura); // Cuenta débito
                    break;
                case 3:
                    nueva = new Credito(id, 0); // Crédito inicia con deuda 0
                    break;
                default:
                    System.out.println("Opción inválida."); // Opción no válida
                    return;
            }

            // Agregamos la cuenta a la lista principal
            cuentas.add(nueva);

            // Insertamos la cuenta en el BST para búsqueda rápida por ID
            raiz = insertarBST(raiz, nueva);

            // Creamos una transacción de apertura de cuenta
            Transaccion transApertura = new Transaccion(id, "Apertura", apertura);

            // Registramos la transacción en la lista de transacciones
            transacciones.add(transApertura);

            // Agregamos la transacción a la cola de procesamiento
            colaTransacciones.add(transApertura);

            // Procesamos la cola de transacciones (simula procesamiento diferido)
            procesarColaTransacciones();

            System.out.println("Cuenta creada exitosamente."); // Mensaje de éxito
        } catch (NumberFormatException e) {
            // Si el usuario ingresa un valor no numérico, se captura la excepción
            System.out.println("Entrada inválida. Operación cancelada.");
        }
    }

    // ----------------------- DEPOSITAR DINERO -----------------------

    public void depositar() {
        try {
            // Solicitamos el ID de la cuenta donde se hará el depósito
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Solicitamos el monto a depositar
            System.out.print("Monto a depositar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            // Buscamos la cuenta en la lista
            Cuenta c = buscarCuenta(id);
            if (c == null) { // Validación: la cuenta debe existir
                System.out.println("Cuenta no encontrada.");
                return;
            }

            // Validación: el monto debe ser positivo
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Se suma el monto al saldo de la cuenta
            c.apertura(monto); // Se asume que el método "apertura" incrementa el saldo

            // Creamos una transacción de depósito
            Transaccion trans = new Transaccion(id, "Depósito", monto);

            // Agregamos la transacción a la lista de transacciones
            transacciones.add(trans);

            // Agregamos la transacción a la cola de procesamiento
            colaTransacciones.add(trans);

            // Procesamos la cola de transacciones (ejemplo de uso de Queue.poll())
            procesarColaTransacciones();

            System.out.println("Depósito exitoso."); // Mensaje de éxito
        } catch (NumberFormatException e) {
            // Captura errores si se ingresa texto en lugar de números
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- RETIRAR DINERO -----------------------
    public void retirar() {
        try {
            // Solicita al usuario el ID de la cuenta donde desea retirar dinero
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim()); // Convierte entrada String a int

            // Solicita el monto a retirar
            System.out.print("Monto a retirar: ");
            double monto = Double.parseDouble(sc.nextLine().trim()); // Convierte String a double

            // Busca la cuenta por ID usando el método auxiliar
            Cuenta c = buscarCuenta(id);

            // Validación: la cuenta debe existir y debe ser de tipo Débito
            // "instanceof" verifica si el objeto es una instancia de cierta clase
            if (c == null || !(c instanceof Debito)) {
                System.out.println("Solo cuentas débito pueden retirar.");
                return; // Sale del método si no cumple la condición
            }

            // Validación: el monto debe ser positivo
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Intentamos retirar el monto
            // El cast ((Debito) c) convierte la cuenta genérica a una cuenta Débito
            // para poder llamar al método específico retirar()
            if (!((Debito) c).retirar(monto)) { // Retorna false si no hay suficiente saldo
                System.out.println("Saldo insuficiente.");
                return;
            }

            // Creamos un objeto Transaccion registrando el retiro
            Transaccion trans = new Transaccion(id, "Retiro", monto);

            // Agregamos la transacción a la lista principal
            transacciones.add(trans);

            // Agregamos la transacción a la cola para procesarla
            colaTransacciones.add(trans);

            // Procesa la cola de transacciones
            procesarColaTransacciones();

            // Mensaje de éxito
            System.out.println("Retiro exitoso.");
        } catch (NumberFormatException e) {
            // Captura errores de conversión si se ingresan letras en lugar de números
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- INVERTIR EN CUENTA DE AHORRO -----------------------
    public void invertirAhorro() {
        try {
            // Solicita el ID de la cuenta de ahorro
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Solicita el monto a invertir
            System.out.print("Monto a invertir: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            // Busca la cuenta por ID
            Cuenta c = buscarCuenta(id);

            // Validación: la cuenta debe existir y ser de tipo Ahorro
            if (c == null || !(c instanceof Ahorro)) {
                System.out.println("Cuenta de ahorro no encontrada.");
                return;
            }

            // Validación: el monto debe ser positivo
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Llamamos al método invertir() de la cuenta de ahorro
            ((Ahorro) c).invertir(monto); // Cast necesario para acceder a métodos de Ahorro

            // Creamos la transacción correspondiente
            Transaccion trans = new Transaccion(id, "Inversión", monto);

            // Agregamos a la lista de transacciones
            transacciones.add(trans);

            // Agregamos a la cola de transacciones
            colaTransacciones.add(trans);

            // Procesamos la cola
            procesarColaTransacciones();

            // Mensaje de éxito
            System.out.println("Inversión realizada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- USAR CRÉDITO -----------------------
    public void usarCredito() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Monto a usar de crédito: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            Cuenta c = buscarCuenta(id);

            // Validación: la cuenta debe existir y ser de tipo Crédito
            if (c == null || !(c instanceof Credito)) {
                System.out.println("Cuenta de crédito no encontrada.");
                return;
            }

            // Validación: monto positivo
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Usamos el crédito llamando al método específico
            ((Credito) c).usarCredito(monto);

            // Registramos la transacción
            Transaccion trans = new Transaccion(id, "Uso de crédito", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();

            System.out.println("Crédito utilizado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- PAGAR CRÉDITO -----------------------
    public void pagarCredito() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Monto a pagar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            Cuenta c = buscarCuenta(id);

            // Validación: solo cuentas de tipo Crédito
            if (c == null || !(c instanceof Credito)) {
                System.out.println("Cuenta de crédito no encontrada.");
                return;
            }

            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Se paga el crédito
            ((Credito) c).pagar(monto);

            // Registramos la transacción
            Transaccion trans = new Transaccion(id, "Pago de crédito", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();

            System.out.println("Pago de crédito exitoso.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- APLICAR INTERÉS A CUENTA DE CRÉDITO
    // -----------------------
    public void aplicarInteresCredito() {
        try {
            System.out.print("ID de la cuenta de crédito: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            Cuenta c = buscarCuenta(id);

            // Validación: debe ser cuenta de crédito
            if (c == null || !(c instanceof Credito)) {
                System.out.println("Cuenta de crédito no encontrada.");
                return;
            }

            // Aplica el interés usando el método de la clase Crédito
            ((Credito) c).aplicarInteres();

            // Registra la transacción de aplicación de interés
            Transaccion trans = new Transaccion(id, "Aplicar interés", 0); // 0 porque no se retira dinero
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();

            System.out.println("Interés aplicado correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- TRANSFERENCIA ENTRE CUENTAS -----------------------
    public void transferir() {
        try {
            // Solicita al usuario el ID de la cuenta de origen (debe ser débito)
            System.out.print("ID cuenta origen (débito): ");
            int idOrigen = Integer.parseInt(sc.nextLine().trim()); // Convertir entrada a int

            // Solicita ID de la cuenta destino
            System.out.print("ID cuenta destino: ");
            int idDestino = Integer.parseInt(sc.nextLine().trim());

            // Solicita el monto a transferir
            System.out.print("Monto a transferir: ");
            double monto = Double.parseDouble(sc.nextLine().trim());

            // Buscamos ambas cuentas en la lista de cuentas
            Cuenta origen = buscarCuenta(idOrigen);
            Cuenta destino = buscarCuenta(idDestino);

            // Validación: ambas cuentas deben existir
            if (origen == null || destino == null) {
                System.out.println("Alguna de las cuentas no existe.");
                return; // Sale del método si alguna no existe
            }

            // Validación: solo cuentas débito pueden transferir
            if (!(origen instanceof Debito)) {
                System.out.println("Solo cuentas débito pueden transferir.");
                return;
            }

            // Validación: monto positivo
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }

            // Intentamos retirar el monto de la cuenta de origen
            if (!((Debito) origen).retirar(monto)) { // Cast para acceder a método retirar()
                System.out.println("Saldo insuficiente.");
                return;
            }

            // Sumamos el monto a la cuenta destino
            // Se llama "apertura" porque el método añade dinero a la cuenta
            destino.apertura(monto);

            // Registramos la transacción indicando de dónde a dónde se transfirió
            Transaccion trans = new Transaccion(idOrigen, "Transferencia a " + idDestino, monto);

            // Agregamos a la lista de transacciones
            transacciones.add(trans);

            // Agregamos a la cola para procesar (demostración de Queue)
            colaTransacciones.add(trans);

            // Procesamos la cola (simula registro/log)
            procesarColaTransacciones();

            System.out.println("Transferencia realizada exitosamente.");
        } catch (NumberFormatException e) {
            // Captura errores si el usuario ingresa texto en lugar de números
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- LISTAR TODAS LAS CUENTAS -----------------------
    public void listarCuentas() {
        // Verifica si la lista de cuentas está vacía
        if (cuentas.isEmpty()) { // isEmpty() retorna true si la lista no tiene elementos
            System.out.println("No hay cuentas registradas.");
            return;
        }

        // Recorremos la lista de cuentas usando un for-each
        for (Cuenta c : cuentas) { // "c" toma cada elemento de la lista "cuentas"
            System.out.println(c); // Imprime la cuenta, llamando al método toString() de Cuenta
        }
    }

    // ----------------------- CONSULTAR SALDO -----------------------
    public void consultarSaldo() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Busca la cuenta por ID
            Cuenta c = buscarCuenta(id);

            // Validación: la cuenta debe existir
            if (c == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }

            // Imprime el saldo usando el método consultarSaldo() de la cuenta
            System.out.println("Saldo actual: " + c.consultarSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida."); // Maneja error de conversión
        }
    }

    // ----------------------- VER TODAS LAS TRANSACCIONES -----------------------
    public void verTransacciones() {
        // Verifica si la lista de transacciones está vacía
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }

        // Recorremos cada transacción y la mostramos en consola
        for (Transaccion t : transacciones) { // for-each
            System.out.println(t); // Llama a toString() de Transaccion
        }
    }

    // ----------------------- VER TRANSACCIONES POR CUENTA -----------------------
    public void verTransaccionesPorCuenta() {
        try {
            System.out.print("Ingrese el ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            boolean hay = false; // Variable para verificar si encontramos transacciones

            System.out.println("\n=== TRANSACCIONES DE LA CUENTA " + id + " ===");

            // Recorremos la lista de transacciones
            for (Transaccion t : transacciones) {
                // Comparamos el ID de la transacción con el ID ingresado
                if (t.getIdCuenta() == id) {
                    System.out.println(t); // Imprime la transacción
                    hay = true; // Marcamos que sí hay transacciones
                }
            }

            // Si no se encontró ninguna transacción, avisamos
            if (!hay) {
                System.out.println("No hay transacciones registradas para esta cuenta.");
            }

            System.out.println("===========================================\n");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida."); // Error si se ingresa texto en vez de número
        }
    }

    // ----------------------- ORDENAMIENTO (no modifican lista original)
    // -----------------------

    // Método público que devuelve un **ArrayList de cuentas ordenadas por saldo**
    // (de menor a mayor)
    public ArrayList<Cuenta> obtenerCuentasOrdenadasPorSaldo() {
        // Creamos una copia de la lista original para no modificarla
        ArrayList<Cuenta> copia = new ArrayList<>(cuentas);

        // Si hay 0 o 1 elemento, ya está ordenada
        if (copia.size() <= 1)
            return copia;

        // Llamamos al método recursivo MergeSort para ordenar por saldo
        return mergeSortPorSaldo(copia);
    }

    // ----------------------- MERGESORT -----------------------
    // Método recursivo que implementa MergeSort para ordenar por saldo
    private ArrayList<Cuenta> mergeSortPorSaldo(ArrayList<Cuenta> lista) {
        // Caso base: si la lista tiene 0 o 1 elemento, ya está ordenada
        if (lista.size() <= 1)
            return lista;

        // Dividimos la lista en dos mitades
        int mitad = lista.size() / 2;
        ArrayList<Cuenta> izquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Cuenta> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        // Llamadas recursivas para ordenar cada mitad
        izquierda = mergeSortPorSaldo(izquierda);
        derecha = mergeSortPorSaldo(derecha);

        // Combinamos las dos mitades ya ordenadas
        return merge(izquierda, derecha);
    }

    // Método que combina dos listas ordenadas en una sola lista ordenada
    private ArrayList<Cuenta> merge(ArrayList<Cuenta> izq, ArrayList<Cuenta> der) {
        ArrayList<Cuenta> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Comparamos elementos de ambas listas y agregamos el menor primero
        while (i < izq.size() && j < der.size()) {
            if (izq.get(i).getMontoActual() <= der.get(j).getMontoActual()) {
                resultado.add(izq.get(i));
                i++; // avanzamos en la lista izquierda
            } else {
                resultado.add(der.get(j));
                j++; // avanzamos en la lista derecha
            }
        }

        // Si quedó algún elemento en la lista izquierda, lo agregamos
        while (i < izq.size()) {
            resultado.add(izq.get(i));
            i++;
        }

        // Si quedó algún elemento en la lista derecha, lo agregamos
        while (j < der.size()) {
            resultado.add(der.get(j));
            j++;
        }

        return resultado; // Devolvemos la lista combinada y ordenada
    }

    // ----------------------- QUICKSORT -----------------------

    // Método público que devuelve un **ArrayList de cuentas ordenadas por ID**
    public ArrayList<Cuenta> obtenerCuentasOrdenadasPorId() {
        ArrayList<Cuenta> copia = new ArrayList<>(cuentas); // Creamos copia para no modificar la original

        // Si la lista tiene 0 o 1 elemento, ya está ordenada
        if (copia.size() <= 1)
            return copia;

        // Llamamos a QuickSort (ordenamiento in-place)
        quickSort(copia, 0, copia.size() - 1);

        return copia;
    }

    // Método recursivo de QuickSort
    private void quickSort(ArrayList<Cuenta> lista, int low, int high) {
        if (low < high) {
            // Obtenemos el índice del pivote después de particionar
            int pi = partition(lista, low, high);

            // Ordenamos recursivamente los elementos antes del pivote
            quickSort(lista, low, pi - 1);

            // Ordenamos recursivamente los elementos después del pivote
            quickSort(lista, pi + 1, high);
        }
    }

    // Método que realiza la partición para QuickSort
    private int partition(ArrayList<Cuenta> lista, int low, int high) {
        int pivot = lista.get(high).getId(); // Elegimos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        // Recorremos la lista y movemos los elementos menores o iguales al pivote al
        // frente
        for (int j = low; j < high; j++) {
            if (lista.get(j).getId() <= pivot) {
                i++;
                // Intercambiamos lista[i] con lista[j]
                Cuenta temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        // Colocamos el pivote en su posición correcta
        Cuenta temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);

        return i + 1; // Devolvemos el índice del pivote
    }

    // ----------------------- BÚSQUEDA BINARIA (usa copia ordenada)
    // -----------------------

    // Método que busca una cuenta por ID usando búsqueda binaria
    public Cuenta buscarCuentaBinaria(int id) {
        // Primero obtenemos una copia de las cuentas ordenadas por ID
        ArrayList<Cuenta> ordenadas = obtenerCuentasOrdenadasPorId();

        // Inicializamos los índices de búsqueda
        int inicio = 0;
        int fin = ordenadas.size() - 1;

        // Ciclo principal de búsqueda binaria
        while (inicio <= fin) {
            // Calculamos el índice medio
            int medio = (inicio + fin) / 2;
            Cuenta cuenta = ordenadas.get(medio); // obtenemos la cuenta del medio

            if (cuenta.getId() == id) // Si encontramos el ID, devolvemos la cuenta
                return cuenta;
            else if (cuenta.getId() < id) // Si el ID del medio es menor, buscamos en la mitad derecha
                inicio = medio + 1;
            else // Si el ID del medio es mayor, buscamos en la mitad izquierda
                fin = medio - 1;
        }

        // Si no se encuentra, devolvemos null
        return null;
    }

    // ----------------------- REPORTE ORDENADO -----------------------

    // Método que imprime un reporte de cuentas ordenadas por saldo
    public void reporteCuentasOrdenadas() {
        // Obtenemos la lista de cuentas ordenadas por saldo (menor a mayor)
        ArrayList<Cuenta> ordenadas = obtenerCuentasOrdenadasPorSaldo();

        // Encabezado del reporte
        System.out.println("\n=== REPORTE DE CUENTAS ORDENADAS POR SALDO ===");

        // Recorremos cada cuenta y mostramos su ID y saldo actual
        for (Cuenta c : ordenadas) {
            System.out.println("ID: " + c.getId() + " | Saldo: " + c.getMontoActual());
        }

        // Pie de reporte
        System.out.println("==============================================\n");
    }

    // ----------------------- ACTUALIZAR / ELIMINAR -----------------------

    // Método que permite actualizar el ID o tipo de una cuenta
    public void actualizarCuenta() {
        try {
            System.out.print("ID de la cuenta que desea actualizar: ");
            int id = Integer.parseInt(sc.nextLine().trim()); // Leemos el ID a actualizar

            // Buscamos la cuenta en la lista de cuentas
            Cuenta c = buscarCuenta(id);
            if (c == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }

            // Menú de opciones de actualización
            System.out.println("\n¿Qué desea actualizar?");
            System.out.println("1. Cambiar ID");
            System.out.println("2. Cambiar tipo de cuenta");
            System.out.print("Opción: ");
            int opc = Integer.parseInt(sc.nextLine().trim());

            switch (opc) {
                case 1:
                    // Cambiar ID
                    System.out.print("Nuevo ID: ");
                    int nuevoId = Integer.parseInt(sc.nextLine().trim());

                    // Validaciones: no se puede usar el mismo ID ni uno ya existente
                    if (nuevoId == id) {
                        System.out.println("El ID es igual al anterior. Nada que hacer.");
                        return;
                    }
                    if (idExiste(nuevoId)) {
                        System.out.println("Ese ID ya está en uso.");
                        return;
                    }

                    // Actualizamos el BST: primero eliminamos el nodo antiguo
                    raiz = eliminarNodoBST(raiz, id);

                    // Cambiamos el ID en la cuenta
                    c.setId(nuevoId);

                    // Insertamos la cuenta actualizada en el BST
                    raiz = insertarBST(raiz, c);
                    System.out.println("ID actualizado correctamente.");
                    break;

                case 2:
                    // Cambiar tipo de cuenta
                    System.out.println("Seleccione nuevo tipo:");
                    System.out.println("1. Ahorro");
                    System.out.println("2. Débito");
                    System.out.println("3. Crédito");
                    System.out.print("Opción: ");
                    int nuevoTipo = Integer.parseInt(sc.nextLine().trim());

                    Cuenta nueva = null;
                    double saldoActual = c.getMontoActual(); // Conservamos el saldo actual
                    int currentId = c.getId(); // ID actual

                    // Creamos la nueva cuenta según el tipo elegido
                    if (nuevoTipo == 1)
                        nueva = new Ahorro(currentId, saldoActual);
                    else if (nuevoTipo == 2)
                        nueva = new Debito(currentId, saldoActual);
                    else if (nuevoTipo == 3)
                        nueva = new Credito(currentId, 0); // Para crédito iniciamos sin deuda
                    else {
                        System.out.println("Opción inválida.");
                        return;
                    }

                    // Reemplazamos la cuenta antigua en la lista de cuentas
                    int index = cuentas.indexOf(c);
                    if (index >= 0) {
                        cuentas.set(index, nueva);

                        // Actualizamos el BST: eliminamos la antigua y agregamos la nueva
                        raiz = eliminarNodoBST(raiz, currentId);
                        raiz = insertarBST(raiz, nueva);

                        System.out.println("Tipo de cuenta actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar: cuenta no encontrada en la lista.");
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- ELIMINAR CUENTA -----------------------

    // Método para eliminar una cuenta del sistema
    public void eliminarCuenta() {
        try {
            // Solicitamos al usuario el ID de la cuenta a eliminar
            System.out.print("ID de la cuenta a eliminar: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Buscamos la cuenta en la lista de cuentas
            Cuenta c = buscarCuenta(id);
            if (c == null) { // Si no existe, mostramos mensaje y salimos
                System.out.println("Cuenta no encontrada.");
                return;
            }

            // Verificamos que la cuenta esté en cero antes de eliminarla
            if (c instanceof Credito) {
                // Para cuentas de crédito, no se puede eliminar si aún hay deuda (< 0)
                if (c.getMontoActual() < 0) {
                    System.out.println("No se puede eliminar. La cuenta de crédito aún tiene deuda.");
                    return;
                }
            } else {
                // Para cuentas Ahorro o Débito, el saldo debe ser exactamente 0
                if (c.getMontoActual() != 0) {
                    System.out.println("No se puede eliminar. La cuenta tiene saldo disponible.");
                    return;
                }
            }

            // Eliminamos la cuenta de la lista de cuentas
            cuentas.remove(c);

            // Eliminamos el nodo correspondiente del BST interno
            raiz = eliminarNodoBST(raiz, id);

            // Eliminamos todas las transacciones asociadas a esta cuenta
            transacciones.removeIf(t -> t.getIdCuenta() == id);

            System.out.println("Cuenta eliminada exitosamente.");

        } catch (NumberFormatException e) {
            // Captura errores si el usuario no ingresa un número válido
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- OPERACIONES SOBRE BST -----------------------

    // Inserta un nodo en el BST. Mantiene el orden por ID
    private NodoBST insertarBST(NodoBST nodo, Cuenta cuenta) {
        if (nodo == null)
            return new NodoBST(cuenta); // Si el nodo actual es null, creamos uno nuevo

        // Si el ID es menor, insertamos en el subárbol izquierdo
        if (cuenta.getId() < nodo.cuenta.getId())
            nodo.izquierda = insertarBST(nodo.izquierda, cuenta);
        // Si el ID es mayor, insertamos en el subárbol derecho
        else if (cuenta.getId() > nodo.cuenta.getId())
            nodo.derecha = insertarBST(nodo.derecha, cuenta);

        // Retornamos el nodo (permite enlazar correctamente recursivamente)
        return nodo;
    }

    // Método público que busca una cuenta en el BST por ID
    public Cuenta buscarEnBST(int id) {
        return buscarBSTRec(raiz, id); // Llama al método recursivo privado
    }

    // Método recursivo para buscar una cuenta en el BST
    private Cuenta buscarBSTRec(NodoBST nodo, int id) {
        if (nodo == null)
            return null; // No encontrado

        if (id == nodo.cuenta.getId())
            return nodo.cuenta; // Encontrado

        // Si el ID es menor, buscamos en el subárbol izquierdo
        if (id < nodo.cuenta.getId())
            return buscarBSTRec(nodo.izquierda, id);
        else // Si es mayor, buscamos en el subárbol derecho
            return buscarBSTRec(nodo.derecha, id);
    }

    // Eliminación estándar de un nodo por id
    // ----------------------- ELIMINACIÓN DE NODOS EN EL BST
    // -----------------------

    // Método principal para eliminar un nodo del BST según el ID de la cuenta
    private NodoBST eliminarNodoBST(NodoBST nodo, int id) {
        if (nodo == null)
            return null; // Caso base: el nodo es nulo, no hay nada que eliminar

        // Si el ID buscado es menor que el del nodo actual, seguimos en el subárbol
        // izquierdo
        if (id < nodo.cuenta.getId())
            nodo.izquierda = eliminarNodoBST(nodo.izquierda, id);

        // Si el ID buscado es mayor que el del nodo actual, seguimos en el subárbol
        // derecho
        else if (id > nodo.cuenta.getId())
            nodo.derecha = eliminarNodoBST(nodo.derecha, id);

        // Nodo encontrado
        else {
            // Caso 1: el nodo no tiene hijo izquierdo → reemplazarlo por su hijo derecho
            if (nodo.izquierda == null)
                return nodo.derecha;

            // Caso 2: el nodo no tiene hijo derecho → reemplazarlo por su hijo izquierdo
            else if (nodo.derecha == null)
                return nodo.izquierda;

            // Caso 3: nodo con dos hijos
            else {
                // Encontrar el sucesor mínimo del subárbol derecho
                NodoBST sucesor = minValueNode(nodo.derecha);

                // Reemplazar la cuenta del nodo actual con la del sucesor
                nodo.cuenta = sucesor.cuenta;

                // Eliminar recursivamente el nodo duplicado en el subárbol derecho
                nodo.derecha = eliminarNodoBST(nodo.derecha, sucesor.cuenta.getId());
            }
        }
        return nodo; // Retornar nodo actualizado para mantener la estructura del BST
    }

    // Método auxiliar para encontrar el nodo con el ID más pequeño en un subárbol
    private NodoBST minValueNode(NodoBST node) {
        NodoBST current = node;
        while (current.izquierda != null) // siempre bajar por la izquierda
            current = current.izquierda;
        return current; // nodo con el valor mínimo
    }

    // Recorridos
    // Recorrido InOrden: izquierda → nodo → derecha
    // Imprime las cuentas en orden ascendente por ID
    public void imprimirInOrden() {
        System.out.println("=== Recorrido InOrden ===");
        inOrden(raiz);
    }

    private void inOrden(NodoBST nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda); // Primero recorrer el subárbol izquierdo
            System.out.println(nodo.cuenta); // Luego procesar el nodo actual
            inOrden(nodo.derecha); // Finalmente recorrer el subárbol derecho
        }
    }

    // Recorrido PreOrden: nodo → izquierda → derecha
    // Útil para clonar o guardar la estructura del árbol
    public void imprimirPreOrden() {
        System.out.println("=== Recorrido PreOrden ===");
        preOrden(raiz);
    }

    private void preOrden(NodoBST nodo) {
        if (nodo != null) {
            System.out.println(nodo.cuenta); // Procesar nodo primero
            preOrden(nodo.izquierda); // Luego subárbol izquierdo
            preOrden(nodo.derecha); // Luego subárbol derecho
        }
    }

    // Recorrido PostOrden: izquierda → derecha → nodo
    // Útil para eliminar nodos del árbol o liberar memoria
    public void imprimirPostOrden() {
        System.out.println("=== Recorrido PostOrden ===");
        postOrden(raiz);
    }

    private void postOrden(NodoBST nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierda); // Primero subárbol izquierdo
            postOrden(nodo.derecha); // Luego subárbol derecho
            System.out.println(nodo.cuenta); // Finalmente el nodo actual
        }
    }

    // ----------------------- Cola de transacciones (demostración de cola/pila)
    // -----------------------
    // Procesa las transacciones de la cola. Aunque en este ejemplo se procesan
    // inmediatamente, sirve para demostrar cómo se puede usar una cola para
    // transacciones pendientes o diferidas.
    private void procesarColaTransacciones() {
        // Mientras haya transacciones en la cola
        while (!colaTransacciones.isEmpty()) {
            Transaccion t = colaTransacciones.poll(); // obtener y remover la primera
            System.out.println("Procesada: " + t); // ejemplo de "procesamiento"
            // Aquí se podría: registrar en un log, guardar en DB, etc.
        }
    }

}