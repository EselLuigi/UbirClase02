package modelo;

public class Pasajero extends Usuario {

    private float valoracionPasajero;
    private MetodoPago metodoPago;

    public Pasajero(String usuario, String contrasenia, String nombre, String apellido, int dni, String mail,
                     MetodoPago metodoPago, float valoracionPasajero) {
        super(usuario, contrasenia, nombre, apellido, dni, mail);
        this.metodoPago = metodoPago;
        this.valoracionPasajero = valoracionPasajero;
        setBilletera(new BilleteraPasajero(0f));
    }

    public void solicitarViaje(String inicio, String fin) {
        System.out.println("\n" + getNombreCompleto() + " solicita un viaje desde \"" + inicio
                + "\" hasta \"" + fin + "\".");

        Viaje viaje = new Viaje(this, inicio, fin);
        viaje.presupuestoViaje();
        System.out.printf("Precio estimado: $%.2f%n", viaje.getPrecio());

        viaje.buscarChofer();
        viaje.notificarOfertaViaje();

        if (viaje.getEstado() == EstadoViaje.ACEPTADO) {
            System.out.println("\n¡Viaje creado con éxito!");
            System.out.println(viaje);
            viaje.ejecutarViaje();
        } else {
            System.out.println("\nEl viaje no se pudo concretar. Estado final: " + viaje.getEstado());
        }
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public BilleteraPasajero getBilleteraPasajero() {
        return (BilleteraPasajero) getBilletera();
    }

    public float getValoracionPasajero() {
        return valoracionPasajero;
    }
}
