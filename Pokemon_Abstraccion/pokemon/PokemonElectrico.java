package pokemon;

public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, int nivel) {
    super(nombre, "Pokemon electrico", nivel);

ListaMovimientos listaMovimientos = new ListaMovimientos();

        setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Puño Trueno"));
        setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Bola voltio "));
        setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Meteoros"));
        setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Garra brutal"));
    }

@Override 
public double obtenerEfectividad (Pokemon pokemon) { 
    double efectividad = 1.0;
        
      if(pokemon.getTipo()== Tipo.AGUA) efectividad = 2.0;
      if(pokemon.getTipo()== Tipo.VOLADOR) efectividad = 2.0;
      if(pokemon.getTipo()== Tipo.ACERO) efectividad = 1.0;
      if(pokemon.getTipo()== Tipo.ELECTRICO) efectividad = 0.5;
      if(pokemon.getTipo()== Tipo.PLANTA) efectividad = 0.5;
      if(pokemon.getTipo()== Tipo.TIERRA) efectividad = 0.0;

    return efectividad;
}
}

