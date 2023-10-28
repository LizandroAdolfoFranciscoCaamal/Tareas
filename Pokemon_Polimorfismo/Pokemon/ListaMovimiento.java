package pokemon;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {

        // Movimientos de tipo electrico
        movimientos.add(new Movimiento("Puño Trueno", 75, Tipo.ELECTRICO, 38, TipoMovimiento.FISICO));
        movimientos.add(new Movimiento("Bola voltio", 60, Tipo.ELECTRICO, 10, TipoMovimiento.ESPECIAL));

        // Movimientos de tipo Fantasma
        movimientos.add(new Movimiento("Puño sombra", 60, Tipo.FANTASMA, 18, TipoMovimiento.FISICO));
        movimientos.add(new Movimiento("Rayo confuso", 100, Tipo.FANTASMA, 5,TipoMovimiento.ESTADO));

        // Movimientos de tipo normal
        movimientos.add(new Movimiento("Meteoros", 68, Tipo.NORMAL, 20, TipoMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Garra brutal", 75, Tipo.NORMAL, 10, TipoMovimiento.FISICO));
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
