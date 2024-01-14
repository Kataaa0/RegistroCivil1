public class RegistroPersona {
    private int cantidadPersonas;
    private Persona[] personas;

    public RegistroPersona(int t) {
        cantidadPersonas = 0;
        personas = new Persona[t];
    }

    public void agregarPersona(Persona persona) {
        try {
            if (cantidadPersonas < personas.length) {
                if (persona != null) {
                    personas[cantidadPersonas] = persona;
                    cantidadPersonas++;
                    System.out.println("Se agregaron los datos correctamente");
                } else {
                    throw new IllegalArgumentException("La persona a agregar no puede ser nula");
                }
            } else {
                System.out.println("No es posible agregar. El registro está lleno.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar persona: " + e.getMessage());
        }
    }

    public Persona buscarPorCedula(String cedula) {
        try {
            for (int i = 0; i < cantidadPersonas; i++) {
                if (personas[i].getCedula().equals(cedula)) {
                    return personas[i];
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error al buscar por cédula: " + e.getMessage());
        }
        return null;
    }

    public Persona buscarPorNombre(String nombre) {
        try {
            for (int i = 0; i < cantidadPersonas; i++) {
                if (personas[i].getNombre().equalsIgnoreCase(nombre)) {
                    return personas[i];
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
        }
        return null;
    }

    public Persona buscarPorFechaNacimiento(String fechaNacimiento) {
        try {
            for (int i = 0; i < cantidadPersonas; i++) {
                if (personas[i].getFechaNacimiento().equals(fechaNacimiento)) {
                    return personas[i];
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error al buscar por fecha de nacimiento: " + e.getMessage());
        }
        return null;
    }

    public void mostrarPersonasRegistradas() {
        System.out.println("Personas registradas en el Registro Civil:");
        for (int i = 0; i < cantidadPersonas; i++) {
            try {
                personas[i].mostrarInformacion();
                System.out.println("--------------------");
            } catch (NullPointerException e) {
                System.out.println("Error al mostrar información de una persona: " + e.getMessage());
            }
        }
    }
}
