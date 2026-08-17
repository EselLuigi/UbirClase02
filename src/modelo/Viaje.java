package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Viaje {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static int contadorId = 0;

    private final int id;
    private float precio;
    private final String inicio;
    private final String fin;
    private final String fecha;
    private final Pasajero pasajero;
    private Chofer chofer;
    private final double area = 30;
    private EstadoViaje estado;

    public Viaje(Pasajero pasajero, String inicio, String fin) {
        this.id = ++contadorId;
        this.pasajero = pasajero;
        this.inicio = inicio;
        this.fin = fin;
        this.fecha = LocalDateTime.now().format(FORMATO_FECHA);
        this.estado = EstadoViaje.PENDIENTE;
    }

    public void presupuestoViaje() {
        double distanciaSimulada = 3 + new Random().nextDouble() * area;
        double tarifaBase = 500;
        double tarifaPorKm = 150;
        this.precio = (float) (tarifaBase + distanciaSimulada * tarifaPorKm);
    }

    public void buscarChofer() {
        System.out.println("Buscando chofer disponible...");
        this.chofer = Chofer.buscarDisponible();
    }

    public void notificarOfertaViaje() {
        if (chofer == null) {
            System.out.println("No hay choferes disponibles en este momento.");
            estado = EstadoViaje.SIN_CHOFER;
            return;
        }

        System.out.println("\n--- Oferta de viaje para " + chofer.getNombreCompleto() + " ---");
        System.out.printf("Pasajero: %s | Desde: %s | Hasta: %s | Precio: $%.2f%n",
                pasajero.getNombreCompleto(), inicio, fin, precio);

        System.out.print(chofer.getNombreCompleto() + ", ¿aceptás el viaje? (s/n): ");
        String respuesta = Consola.IN.nextLine().trim().toLowerCase();

        if (respuesta.equals("s") || respuesta.equals("si")) {
            chofer.aceptarViaje(this);
        } else {
            chofer.declinarViaje(this);
        }
    }

    public void ejecutarViaje() {
        System.out.println("\nEjecutando viaje...");
        pasajero.getMetodoPago().procesarPago(precio);
        chofer.getBilleteraChofer().cobrar(precio);
        estado = EstadoViaje.FINALIZADO;
        System.out.println("Viaje finalizado. Estado: " + estado);
    }

    public void actualizarEstado(EstadoViaje nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public EstadoViaje getEstado() {
        return estado;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("Viaje #%d | %s -> %s | %s | Pasajero: %s | Chofer: %s | Precio: $%.2f | Estado: %s",
                id, inicio, fin, fecha, pasajero.getNombreCompleto(),
                chofer != null ? chofer.getNombreCompleto() : "-", precio, estado);
    }
}
