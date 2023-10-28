package pokemon;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {

        // Movimientos de tipo electrico
        movimientos.add(new Movimiento("Puño Trueno", 75, Tipo.ELECTRICO, 38, ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Bola voltio", 60, Tipo.ELECTRICO, 10, ClaseMovimiento.ESPECIAL)oMovimiento.ESPECIAL));

        // Movimientos de tipo Fantasma
        movimientos.add(new Movimiento("Puño sombra", 60, Tipo.FANTASMA, 18, ClaseMovimiento.FISICO));
        movimientos.add(new Movimiento("Rayo confuso", 100, Tipo.FANTASMA, 5, ClaseMovimiento.ESTADO));

        // Movimientos de tipo normal
        movimientos.add(new Movimiento("Meteoros", 68, Tipo.NORMAL, 20, ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Garra brutal", 75, Tipo.NORMAL, 10, ClaseMovimiento.FISICO));
    }

    public Movimiento buscarMovimientoPorNombre(String nombre) {
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getNombre().equals(nombre)) {
                return movimiento;
            }
        }
        return null;

    }
}
