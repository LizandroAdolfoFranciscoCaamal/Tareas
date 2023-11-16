import java.util.Scanner;

public class CajeroAutomaticoMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Cajero Automatico");
        System.out.print("Ingrese su Usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su NIP de 4 digitos: ");
        int nip = scanner.nextInt();

        if (nombre.equals("admin") && nip == 3243) {
            Admin admin = new Admin();
            admin.iniciar();
        } else {
            Cajero cajero = new Cajero(nombre, nip);
            cajero.iniciar();
        }

        scanner.close();
    }
}
