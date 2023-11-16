import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Cajero {

    private String nombre;
    private int nip;
    private int saldo;
    private Random random = new Random();

    public Cajero(String nombre, int nip) {
        this.nombre = nombre;
        this.nip = nip;
        this.saldo = random.nextInt(49001) + 1000;
    }

    public void iniciar() {
        cargarBilletes();

        while (true) {
            mostrarMenu();
            int opcion = solicitarOpcion();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarEfectivo();
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el Cajero Automático. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        }
    }
