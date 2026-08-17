package modelo;

import java.util.ArrayList;
import java.util.List;

public class Chofer extends Usuario {

    private static final List<Chofer> disponibles = new ArrayList<>();

    private Licencia licenciaConducir;
    private Vehiculo vehiculo;
    private float puntajeChofer;

    public Chofer(String usuario, String contrasenia, String nombre, String apellido, int dni, String mail,
                   Licencia licenciaConducir, Vehiculo vehiculo, float puntajeChofer) {
        super(usuario, contrasenia, nombre, apellido, dni, mail);
        this.licenciaConducir = licenciaConducir;
        this.vehiculo = vehiculo;
        this.puntajeChofer = puntajeChofer;
        setBilletera(new BilleteraChofer(0f, 0.20f));
    }

    public static void registrar(Chofer chofer) {
        disponibles.add(chofer);
    }

    public static Chofer buscarDisponible() {
        return disponibles.isEmpty() ? null : disponibles.get(0);
    }

    public void aceptarViaje(Viaje viaje) {
        viaje.setChofer(this);
        viaje.actualizarEstado(EstadoViaje.ACEPTADO);
        System.out.println(getNombreCompleto() + " aceptó el viaje.");
    }

    public void declinarViaje(Viaje viaje) {
        viaje.actualizarEstado(EstadoViaje.RECHAZADO);
        System.out.println(getNombreCompleto() + " declinó el viaje.");
    }

    public BilleteraChofer getBilleteraChofer() {
        return (BilleteraChofer) getBilletera();
    }

    public Licencia getLicenciaConducir() {
        return licenciaConducir;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public float getPuntajeChofer() {
        return puntajeChofer;
    }
}
