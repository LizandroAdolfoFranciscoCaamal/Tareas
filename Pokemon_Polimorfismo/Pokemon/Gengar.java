package pokemon;

public class Gengar extends Pokemon {


  public Gengar(String nombre, int nivel) {
    super(nombre, nivel,);

    ListaMovimientos listaMovimientos = new ListaMovimientos();

    setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Puño sombra"));
    setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Rayo confuso"));
    setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Meteoros"));
    setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Garra brutal"));
  }

  @Override
  public double obtenerEfectividad(Pokemon pokemon) {
    double efectividad = 1.0;

    if (pokemon.getTipo() == Tipo.PSIQUICO)
      efectividad = 2.0;
    if (pokemon.getTipo() == Tipo.FANTASMA)
      efectividad = 2.0;
    if (pokemon.getTipo() == Tipo.BICHO)
      efectividad = 1.0;
    if (pokemon.getTipo() == Tipo.SINIESTRO)
      efectividad = 0.5;
    if (pokemon.getTipo() == Tipo.ACERO)
      efectividad = 0.5;
    if (pokemon.getTipo() == Tipo.LUCHA)
      efectividad = 0.0;
    if (pokemon.getTipo() == Tipo.NORMAL)
      efectividad = 0.0;

    return efectividad;
  }
}