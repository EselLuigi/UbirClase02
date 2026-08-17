package modelo;

public abstract class BilleteraVirtual {

    protected float saldo;

    protected BilleteraVirtual(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }
}
