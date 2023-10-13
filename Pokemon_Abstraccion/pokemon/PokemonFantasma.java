package pokemon;

public class PokemonFantasma extends Pokemon {
    public PokemonFantasma(String nombre, int nivel) {
    super(nombre, "Pokemon fantasma", nivel);
}
  @Override 
  public double obtenerEfectividad (Pokemon pokemon) { 
      return 1.0; 
  }
}
