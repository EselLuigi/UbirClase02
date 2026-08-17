package modelo;

public class TarjetaCredito extends MetodoPago {

    private String numTarjeta;
    private String fechaExp;
    private String banco;
    private String redPago;

    public TarjetaCredito(String numTarjeta, String fechaExp, String banco, String redPago) {
        this.numTarjeta = numTarjeta;
        this.fechaExp = fechaExp;
        this.banco = banco;
        this.redPago = redPago;
    }

    @Override
    public void procesarPago(float importe) {
        String ultimosDigitos = numTarjeta.substring(Math.max(0, numTarjeta.length() - 4));
        System.out.printf("Procesando pago de $%.2f con tarjeta %s de %s terminada en %s...%n",
                importe, redPago, banco, ultimosDigitos);
        System.out.println("Pago aprobado.");
    }

    public String getFechaExp() {
        return fechaExp;
    }
}
