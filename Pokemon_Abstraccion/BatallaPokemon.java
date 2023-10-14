
import pokemon.PokemonElectrico;
import pokemon.PokemonFantasma;

public class BatallaPokemon {

    public static void main(String[] args) {
       PokemonElectrico Raichu = new PokemonElectrico("Raichu", 10);
       PokemonFantasma Gengar = new PokemonFantasma("Gengar", 10);
       
       
        Raichu.atacar(0, Gengar);
        System.out.println("Gengar tiene ahora " +Gengar.getHP()+", puntos de nivel de vida");
        
        Gengar.atacar(3, Raichu);
        System.out.println("Raichu tiene ahora " +Raichu.getHP()+", puntos de nivel de vida");
        
    }
}
