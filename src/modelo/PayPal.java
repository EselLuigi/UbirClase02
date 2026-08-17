package modelo;

public class PayPal extends MetodoPago {

    private String email;
    private String nombre;
    private String dni;

    public PayPal(String email, String nombre, String dni) {
        this.email = email;
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public void procesarPago(float importe) {
        System.out.printf("Procesando pago de $%.2f con PayPal (cuenta %s)...%n", importe, email);
        System.out.println("Pago aprobado.");
    }
}
