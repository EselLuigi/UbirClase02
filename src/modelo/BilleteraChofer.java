package modelo;

public class BilleteraChofer extends BilleteraVirtual {

    private float comisionChofer;

    public BilleteraChofer(float saldo, float comisionChofer) {
        super(saldo);
        this.comisionChofer = comisionChofer;
    }

    public void cobrar(float importe) {
        float comision = calcularComisionChofer(importe);
        saldo += importe - comision;
    }

    public float calcularComisionChofer(float comision) {
        return comision * comisionChofer;
    }
}
