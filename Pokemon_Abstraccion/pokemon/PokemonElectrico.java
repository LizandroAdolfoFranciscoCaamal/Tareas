package pokemon;

public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, int nivel) {
    super(nombre, "Pokemon electrico", nivel);
}
@Override 
public double obtenerEfectividad (Pokemon pokemon) { 
    return 1.0; 
}
}
