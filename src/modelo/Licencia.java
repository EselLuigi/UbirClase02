package modelo;

import java.time.LocalDate;

public class Licencia {

    private String nro;
    private String categoria;
    private LocalDate vencimiento;

    public Licencia(String nro, String categoria, LocalDate vencimiento) {
        this.nro = nro;
        this.categoria = categoria;
        this.vencimiento = vencimiento;
    }

    public boolean estaVigente() {
        return vencimiento.isAfter(LocalDate.now());
    }

    public String getNro() {
        return nro;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }
}
