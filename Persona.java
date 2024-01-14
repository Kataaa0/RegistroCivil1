import java.util.Scanner;

public class Persona {
    private String cedula;
    private String nombre;
    private String fechaNacimiento;

    public Persona(String cedula, String nombre, String fechaNacimiento) {
        // Se podrían lanzar excepciones aquí si los valores iniciales no son válidos.
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setFechaNacimiento(fechaNacimiento);
    }

    public void mostrarInformacion() {
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
    }

    public void setCedula(String cedula) {
        // Agregamos una excepción para el formato de cédula
        if (cedula.matches("\\d{10}")) {
            this.cedula = cedula;
        } else {
            throw new IllegalArgumentException("La cédula debe tener 10 dígitos numéricos.");
        }
    }

    public void setNombre(String nombre) {
        // Agregamos una excepción para el nombre nulo o vacío
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        // Agregamos una excepción para el formato de fecha de nacimiento
        if (fechaNacimiento.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            throw new IllegalArgumentException("El formato de fecha de nacimiento debe ser yyyy-MM-dd.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
        String fechaNacimiento = scanner.nextLine();

        try {
            Persona persona = new Persona(cedula, nombre, fechaNacimiento);
            persona.mostrarInformacion();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Object getCedula() {
        return null;
    }

    public String getNombre() {
        return null;
    }

    public Object getFechaNacimiento() {
        return null;
    }
}
