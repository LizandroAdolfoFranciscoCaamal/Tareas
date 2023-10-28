package pokemon;

public abstract class Pokemon {
    private int hp;
    private String nombre;
    private Tipo tipo;
    private Stats stats;
    private Movimiento movimientos[];

    public Pokemon(String nombre, Tipo tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.stats = new stats();
        this.hp = 250;
        this.movimientos = new Movimiento[4];
    }

    public int getHP() {
        return hp;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public Stats getStats() {
        return stats;
    }
    
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Movimiento getMovimientos(int i) {
        return this.movimientos[i];
    }

    public void setMovimientos(int i, Movimiento movimientos) {
        this.movimientos[i] = movimientos;
    }
    
    private void calcularVida(double vidaRestante, double efectividad) {
        double puntosRestados = vidaRestante * efectividad;
        this.hp -= puntosRestados;
        System.out.printf("% recibe % puntos de vida\n", this.getNombre(), puntosRestados);
    }

    private void calcularDanio(int danio, double efectividad) {
        int variacion = (int)(85+Math.random()*16);
        double puntosRestados = (0.01* efectividad * variacion * (danio));
        this.hp -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de danio\n", this.getNombre(), puntosRestados);
        this.calculaVida(puntosRestados, efectividad);
    }

    public void recibirAtaque(Movimiento movimiento, double efectividad) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), movimiento.getNombre());
        calcularDanio(movimiento.getPuntosDeAtaque(), efectividad);
    }

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);

        if (movimiento.getPp() > 0) {
            pokemon.recibirAtaque(movimiento, efectividad);
            return true;
        } else {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon) {
        Movimiento movimiento = getMovimientos(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
        if (seHaConcretadoAtaque) {
            pokemon.getMovimientos(m).setPp(movimiento.getPp() - 1);
        }
    }

    


    public abstract double obtenerEfectividad(Pokemon pokemon);
}
