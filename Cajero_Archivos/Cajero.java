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
                    System.out.println("Su tranccion ha sido completada." +
                            "\nGracias por utilizar nuestros servicios");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opcion correcta.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n¿En que podemos ayudarte?:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar efectivo");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int solicitarOpcion() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
        guardarLogs("Consultar", saldo, "SI");
    }

    private void retirarEfectivo() {
        System.out.print("Ingrese la cantidad a retirar: ");
        Scanner scanner = new Scanner(System.in);
        int cantidadRetirar = scanner.nextInt();

        if (cantidadRetirar <= saldo) {
            // Verificar disponibilidad de billetes
            if (verificarDisponibilidadBilletes(cantidadRetirar)) {
                // Realizar retiro
                saldo -= cantidadRetirar;
                actualizarBilletes(cantidadRetirar);
                guardarLogs("Retirar", cantidadRetirar, "SI");
                System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
            } else {
                System.out.println("No hay billetes suficientes para realizar el retiro.");
                guardarLogs("Retirar", cantidadRetirar, "NO");
            }
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
            guardarLogs("Retirar", cantidadRetirar, "NO");
        }
    }

    private void cargarBilletes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("billetes.dat"))) {
            Billetes billetes = (Billetes) ois.readObject();
            Billetes.setInstance(billetes);
        } catch (IOException | ClassNotFoundException e) {
            Billetes.setInstance(new Billetes(100, 100, 20, 10));
        }
    }

    private boolean verificarDisponibilidadBilletes(int cantidad) {
        return Billetes.getInstance().verificarDisponibilidad(cantidad);
    }

    private void actualizarBilletes(int cantidadRetirar) {
        Billetes.getInstance().actualizarBilletes(cantidadRetirar);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("billetes.dat"))) {
            oos.writeObject(Billetes.getInstance());
        } catch (IOException e) {
            System.out.println("Error de información de billetes.");
            e.printStackTrace();
        }
    }

    private void guardarLogs(String accion, int monto, String seRealizo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("logs.txt", true))) {
            writer.println(accion + ", " + nombre + ", " + monto + ", " + seRealizo);
        } catch (IOException e) {
            System.out.println("Error al guardar el log.");
            e.printStackTrace();
        }
    }
}
