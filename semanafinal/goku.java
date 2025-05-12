import java.util.Random;
private static final int FUERZA = 5;
private static final int Resistecia = 6;


public class Goku extends Personaje {

     public Goku(String nombre) {
        super(nombre);
     }
     @Override
    public void atacar(Personaje oponente) {
        // Usamos el método calcularDanoBase() de Personaje para calcular el daño base
        int danoBase = calcularDanoBase();
        int danoTotal = danoBase + FUERZA;  // Se agrega la fuerza del Guerrero al daño base

        oponente.recibirDano(danoTotal);
        System.out.println(getNombre() + " ataca con" + golpe + " causando " + danoTotal + " puntos de daño.");
    }
      public int getFuerza() {
        return FUERZA;
    }

    public String getArma() {
        return ARMA;
    }
}

     
    