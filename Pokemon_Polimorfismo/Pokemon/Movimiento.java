package pokemon;

public class Movimiento {

    private String nombre;
    private int puntosDeAtaque;
    private int pp;
    private Tipo tipo;
    private ClaseMovimiento movimiento;

    public Movimiento(String nombre, int puntosDeAtaque, Tipo Tipo, int pp, ClaseMovimiento movimiento) {
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.pp = pp;
        this.movimiento = movimiento

    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public ClaseMovimiento getmovimiento() {
         return movimiento;
    }

}
