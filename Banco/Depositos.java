public class Depositos {
    /**
     * Ejecuta un depósito en la cuenta. Retorna true si fue exitoso.
     */
    public static boolean ejecutar(Cuenta cuenta, double monto) {
        if (cuenta == null) return false;
        return cuenta.depositar(monto);
    }
}
