

import pokemon.Raichu;
import pokemon.Gengar;

public class BatallaPokemon {

    public static void main(String[] args) {
        Raichu Raichu = new Raichu("Raichu", 10);
        Gengar Gengar = new Gengar("Gengar", 10);

        Raichu.atacar(0, Gengar);
        System.out.println("Gengar tiene ahora " + Gengar.getHP() + ", puntos de nivel de vida");

        Gengar.atacar(3, Raichu);
        System.out.println("Raichu tiene ahora " + Raichu.getHP() + ", puntos de nivel de vida");

    }
}
