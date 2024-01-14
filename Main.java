// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            RegistroCivil ejecutar = new RegistroCivil(2);
            ejecutar.menu();
        } catch (InputMismatchException e) {
            System.out.println("Error de entrada. Ingrese un valor válido.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
