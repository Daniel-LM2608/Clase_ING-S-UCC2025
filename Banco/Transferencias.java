public class Transferencias {
    /**
     * Retira de la cuenta origen y deposita en la cuenta destino.
     * Retorna true si la transferencia se completó.
     */
    public static boolean ejecutar(Cuenta origen, Cuenta destino, double monto) {
        if (origen == null || destino == null) return false;
        if (monto <= 0) return false;

        // Intentamos retirar del origen
        boolean okRetiro = origen.retirar(monto);
        if (!okRetiro) return false;

        // Si retiro ok, depositamos en destino (este depósito no debe fallar con monto > 0)
        boolean okDeposito = destino.depositar(monto);
        if (!okDeposito) {
            // rollback: devolver el dinero al origen (intentar restaurar estado)
            origen.depositar(monto);
            return false;
        }
        return true;
    }
}
