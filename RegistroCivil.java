import java.util.Scanner;

public class RegistroCivil {
    private RegistroPersona registro;

    public RegistroCivil(int t) {
        registro = new RegistroPersona(t);
    }

    private void mostrarMenu() {
        System.out.println("1. Registrar nueva persona");
        System.out.println("2. Buscar persona por cedula");
        System.out.println("3. Buscar persona por nombre");
        System.out.println("4. Buscar persona por fecha de nacimiento");
        System.out.println("5. Mostrar personas registradas");
        System.out.println("0. Salir");
    }

    private void registrarPersona(Scanner scanner) {
        try {
            System.out.print("Ingrese la cedula: ");
            String cedula = scanner.nextLine();
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
            String fechaNacimiento = scanner.nextLine();

            Persona nuevaPersona = new Persona(cedula, nombre, fechaNacimiento);
            registro.agregarPersona(nuevaPersona);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar persona: " + e.getMessage());
        }
    }

    private void mostrarResultadoBusqueda(Persona persona) {
        if (persona != null) {
            persona.mostrarInformacion();
        } else {
            System.out.println("No existen esos datos registrados en el sistema");
        }
    }

    private void buscarPorCedula(Scanner scanner) {
        System.out.print("Ingrese la cedula a buscar: ");
        String cedulaBuscar = scanner.nextLine();
        try {
            Persona personaPorCedula = registro.buscarPorCedula(cedulaBuscar);
            mostrarResultadoBusqueda(personaPorCedula);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar por cédula: " + e.getMessage());
        }
    }

    private void buscarPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscar = scanner.nextLine();
        try {
            Persona personaPorNombre = registro.buscarPorNombre(nombreBuscar);
            mostrarResultadoBusqueda(personaPorNombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
        }
    }

    private void buscarPorFechaNacimiento(Scanner scanner) {
        System.out.print("Ingrese la fecha de nacimiento a buscar (yyyy-MM-dd): ");
        String fechaNacimientoBuscar = scanner.nextLine();
        try {
            Persona personaPorFechaNacimiento = registro.buscarPorFechaNacimiento(fechaNacimientoBuscar);
            mostrarResultadoBusqueda(personaPorFechaNacimiento);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al buscar por fecha de nacimiento: " + e.getMessage());
        }
    }

    private void mostrarPersonasRegistradas() {
        registro.mostrarPersonasRegistradas();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese la opcion que desea realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarPersona(scanner);
                    break;

                case 2:
                    buscarPorCedula(scanner);
                    break;

                case 3:
                    buscarPorNombre(scanner);
                    break;

                case 4:
                    buscarPorFechaNacimiento(scanner);
                    break;

                case 5:
                    mostrarPersonasRegistradas();
                    break;

                case 0:
                    System.out.println("Gracias por su consulta.");
                    break;

                default:
                    System.out.println("Opcion invalida, ingresar una opcion entre 0 y 5");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
