

public class CajeroAutomáticoMain {
    public static void main(String[] args) {
        // Solicitar nombre y pin
        String nombre = obtenerEntradaUsuario("Ingrese su nombre: ");
        int pin = obtenerPin("Ingrese el PIN: ");

        // Verificar acceso al modo administrador o cajero
        if (nombre.equalsIgnoreCase("admin") && pin == 3243) {
            // Acceder al modo administrador
            Administrador admin = new Administrador();
            admin.iniciarAdministrador();
        } else {
            // Acceder al modo cajero
            CajeroAutomático cajero = new CajeroAutomático(nombre, pin);
            cajero.iniciarCajero();
        }
    }

    private static St
