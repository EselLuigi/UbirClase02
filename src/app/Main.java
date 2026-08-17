package app;

import java.time.LocalDate;

import modelo.Chofer;
import modelo.Consola;
import modelo.Licencia;
import modelo.Pasajero;
import modelo.TarjetaCredito;
import modelo.Vehiculo;

public class Main {

    public static void main(String[] args) {
        Consola.init();
        System.out.println("=== Simulador de viajes UBIR ===\n");

        Chofer chofer = new Chofer(
                "jperez", "1234", "Juan", "Perez", 30111222, "jperez@mail.com",
                new Licencia("B-45678123", "Profesional", LocalDate.of(2027, 6, 30)),
                new Vehiculo("AC123XZ", "2026-02-15", "Toyota", "Corolla", "Gris"),
                4.8f);
        Chofer.registrar(chofer);

        Pasajero pasajero = new Pasajero(
                "mgomez", "abcd", "Martina", "Gomez", 28555666, "mgomez@mail.com",
                new TarjetaCredito("4111111111111111", "12/28", "Banco Nacion", "Visa"),
                4.9f);

        System.out.println("Chofer disponible: " + chofer.getNombreCompleto()
                + " - " + chofer.getVehiculo());
        System.out.println("Pasajero: " + pasajero.getNombreCompleto());

        System.out.print("\nIngresá el punto de partida: ");
        String inicio = Consola.IN.nextLine();
        System.out.print("Ingresá el destino: ");
        String fin = Consola.IN.nextLine();

        pasajero.solicitarViaje(inicio, fin);
    }
}
