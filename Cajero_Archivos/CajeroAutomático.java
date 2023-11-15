import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CajeroAutomático {
    private String usuario;
    private int saldoMaximo = 50000;
    private int saldo;
    private int pin;
    private static final String LOG_FILE = "logs.txt";
    private static final String BILLETES_FILE = "billetes.dat";
    private Map<Integer, Billete> billetes = new HashMap<>();

    public CajeroAutomático(String usuario, int pin) {
        this.usuario = usuario;
        this.pin = pin;
        this.saldo = new Random().nextInt(saldoMaximo - 1000) + 1000;
        inicializarBilletes();
    }

    private void inicializarBilletes() {
        cargarBilletesDesdeArchivo();
        if (billetes.isEmpty()) {
            billetes.put(100, new Billete(100, 100));
            billetes.put(200, new Billete(200, 100));
            billetes.put(500, new Billete(500, 20));
            billetes.put(1000, new Billete(1000, 10));
            guardarBilletesEnArchivo();
        }
    }
