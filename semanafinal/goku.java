import java.util.Random;
private static final int FUERZA = 5;
private static final int Resistecia = 6;
private static final String ATAQUE DE KI = 10;


public class Goku extends Personaje {

     public Goku(String nombre) {
        super(nombre);
     }

    @Override
    public void atacar(Personaje oponente) {
        System.out.println(getNombre() + " realiza un poderoso ");
        super.atacar(oponente);
    }
      public int getFuerza() {
        return FUERZA;
    }

    public String getArma() {
        return ARMA;
    }
}

     
    