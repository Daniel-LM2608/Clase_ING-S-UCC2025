import java.util.Random;

public class Scorpion extends Personaje {

    public Scorpion() {
        super("Scorpion"); // Llama al constructor de la clase padre con el nombre
    }

    @Override
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt(21) + 10; // 10 a 30
        dano += 10; // Daño adicional por fuego

        oponente.recibirDano(dano);

        System.out.println("Scorpion grita 'Get over here!' y lanza fuego a " +
                           oponente.getNombre() + ", causando " + dano + " puntos de daño.");
    }
}
