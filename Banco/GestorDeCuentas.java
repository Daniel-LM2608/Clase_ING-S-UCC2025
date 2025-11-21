import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeCuentas {

    private ArrayList<Cuenta> cuentas;
    private ArrayList<Transaccion> transacciones;
    private Scanner sc;

    public GestorDeCuentas() {
        cuentas = new ArrayList<>();
        transacciones = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public Cuenta buscarCuenta(int id) {
        for (Cuenta c : cuentas) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void crearCuenta() {
        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Ahorro");
        System.out.println("2. Débito");
        System.out.println("3. Crédito");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();

        System.out.print("Monto de apertura (>=0): ");
        double apertura = sc.nextDouble();

        Cuenta nueva = null;

        switch (opc) {
            case 1: nueva = new Ahorro(id, apertura); break;
            case 2: nueva = new Debito(id, apertura); break;
            case 3: nueva = new Credito(id, apertura); break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        cuentas.add(nueva);
        transacciones.add(new Transaccion(id, "Apertura", apertura));
        System.out.println("Cuenta creada exitosamente.");
    }

    public void depositar() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a depositar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        c.apertura(monto);
        transacciones.add(new Transaccion(id, "Depósito", monto));
        System.out.println("Depósito exitoso.");
    }

    public void retirar() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a retirar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Debito)) {
            System.out.println("Solo cuentas débito pueden retirar.");
            return;
        }
        if (monto <= 0 || c.consultarSaldo() < monto) {
            System.out.println("Monto inválido o saldo insuficiente.");
            return;
        }

        ((Debito) c).retirar(monto);
        transacciones.add(new Transaccion(id, "Retiro", monto));
        System.out.println("Retiro exitoso.");
    }

    public void invertirAhorro() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a invertir: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Ahorro)) {
            System.out.println("Cuenta de ahorro no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Ahorro) c).invertir(monto);
        transacciones.add(new Transaccion(id, "Inversión", monto));
        System.out.println("Inversión realizada exitosamente.");
    }

    public void usarCredito() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a usar de crédito: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Credito) c).usarCredito(monto);
        transacciones.add(new Transaccion(id, "Uso de crédito", monto));
        System.out.println("Crédito utilizado exitosamente.");
    }

    public void pagarCredito() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a pagar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Credito) c).pagar(monto);
        transacciones.add(new Transaccion(id, "Pago de crédito", monto));
        System.out.println("Pago de crédito exitoso.");
    }

    public void aplicarInteresCredito() {
        System.out.print("ID de la cuenta de crédito: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }

        ((Credito) c).aplicarInteres();
        transacciones.add(new Transaccion(id, "Aplicar interés", 0));
        System.out.println("Interés aplicado correctamente.");
    }

    public void transferir() {
        System.out.print("ID cuenta origen (débito): ");
        int idOrigen = sc.nextInt();
        System.out.print("ID cuenta destino: ");
        int idDestino = sc.nextInt();
        System.out.print("Monto a transferir: ");
        double monto = sc.nextDouble();

        Cuenta origen = buscarCuenta(idOrigen);
        Cuenta destino = buscarCuenta(idDestino);

        if (origen == null || destino == null) {
            System.out.println("Alguna de las cuentas no existe.");
            return;
        }
        if (!(origen instanceof Debito)) {
            System.out.println("Solo cuentas débito pueden transferir.");
            return;
        }
        if (monto <= 0 || origen.consultarSaldo() < monto) {
            System.out.println("Monto inválido o saldo insuficiente.");
            return;
        }

        ((Debito) origen).retirar(monto);
        destino.apertura(monto);
        transacciones.add(new Transaccion(idOrigen, "Transferencia a " + idDestino, monto));
        System.out.println("Transferencia realizada exitosamente.");
    }

    public void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
    }

    public void consultarSaldo() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);
        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.println("Saldo actual: " + c.consultarSaldo());
    }

    public void verTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }
        for (Transaccion t : transacciones) {
            System.out.println(t);
        }
    }
}

