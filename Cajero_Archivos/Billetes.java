import java.io.Serializable;

public class Billetes implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private static Billetes instance;

    private int cantidad100;
    private int cantidad200;
    private int cantidad500;
    private int cantidad1000;

    public Billetes(int cantidad100, int cantidad200, int cantidad500, int cantidad1000) {
        this.cantidad100 = cantidad100;
        this.cantidad200 = cantidad200;
        this.cantidad500 = cantidad500;
        this.cantidad1000 = cantidad1000;
    }

    public static void setInstance(Billetes billetes) {
        instance = billetes;
    }

    public static Billetes getInstance() {
        if (instance == null) {
            instance = new Billetes(0, 0, 0, 0);
        }
        return instance;
    }

    public int getCantidad100() {
        return cantidad100;
    }

    public int getCantidad200() {
        return cantidad200;
    }

    public int getCantidad500() {
        return cantidad500;
    }

    public int getCantidad1000() {
        return cantidad1000;
    }

    public boolean verificarDisponibilidad(int cantidad) {
        int totalDisponible = cantidad100 * 100 + cantidad200 * 200 + cantidad500 * 500 + cantidad1000 * 1000;
        return totalDisponible >= cantidad;
    }

    public void actualizarBilletes(int cantidadRetirar) {
        while (cantidadRetirar >= 1000 && cantidad1000 > 0) {
            cantidadRetirar -= 1000;
            cantidad1000--;
        }
        while (cantidadRetirar >= 500 && cantidad500 > 0) {
            cantidadRetirar -= 500;
            cantidad500--;
        }
        while (cantidadRetirar >= 200 && cantidad200 > 0) {
            cantidadRetirar -= 200;
            cantidad200--;
        }
        while (cantidadRetirar >= 100 && cantidad100 > 0) {
            cantidadRetirar -= 100;
            cantidad100--;
        }
    }
}
