import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {

    // Movimientos de tipo electrico
    movimientos.add(new Movimiento ("Puño Trueno", 75, Tipo.ELECTRICO, 38));
    movimientos.add(new Movimiento ("Bola voltio", 60, Tipo.ELECTRICO, 10));

    // Movimientos de tipo Fantasma
    movimientos.add(new Movimiento ("Puño sombra", 60, Tipo.FANTASMA 18));
    movimientos.add(new Movimiento ("Rayo confuso", 100, Tipo.FANTASMA, 5)); 

    // Movimientos de tipo normal
    Movimientos.add(new Movimiento ("Meteoros", 68, Tipo. NORMAL, 20));

    public Movimiento buscarMovimientoPorNombre(String nombre) {
        for (Movimiento movimiento: movimientos) { 
            if (movimiento.getNombre().equals(nombre)) {
            return movimiento;
            }
        }
        return null;
    }
}
