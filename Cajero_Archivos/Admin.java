import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    public void iniciar() {
        while (true) {
            mostrarMenuAdmin();
            int opcion = solicitarOpcionAdmin();

            switch (opcion) {
                case 1:
                    mostrarLog();
                    System.out.println("Mostrar log de acciones.");
                    break;
                case 2:
                    mostrarCantidadBilletes();
                    System.out.println("Mostrar cantidad de billetes.");
                    break;
                case 3:
                    System.out.println("Modo administrador finalizado.");
                    System.exit(0);
                default:
                    System.out.println("Opcion no válida. Por favor, seleccione una opcion correcta.");
            }
        }
    }

    public void mostrarMenuAdmin() {
        System.out.println("\nBienvenido Administrador " +
                "\nOpciones de modo administrador:");
        System.out.println("1. Mostrar log de acciones");
        System.out.println("2. Mostrar cantidad de billetes");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public int solicitarOpcionAdmin() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void mostrarLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el log.");
            e.printStackTrace();
        }
    }

    public void mostrarCantidadBilletes() {
        System.out.println("Cantidad de billetes disponibles:");
        System.out.println("Billetes de $100: " + Billetes.getInstance().getCantidad100());
        System.out.println("Billetes de $200: " + Billetes.getInstance().getCantidad200());
        System.out.println("Billetes de $500: " + Billetes.getInstance().getCantidad500());
        System.out.println("Billetes de $1,000: " + Billetes.getInstance().getCantidad1000());
    }
}
