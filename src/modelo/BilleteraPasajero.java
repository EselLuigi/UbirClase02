package modelo;

public class BilleteraPasajero extends BilleteraVirtual {

    public BilleteraPasajero(float saldo) {
        super(saldo);
    }

    public void realizarPago(float importe) {
        if (importe > saldo) {
            throw new IllegalStateException("Saldo insuficiente en la billetera del pasajero");
        }
        saldo -= importe;
    }

    public void recargarSaldo(float importe) {
        saldo += importe;
    }
}
