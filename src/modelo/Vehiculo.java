package modelo;

public class Vehiculo {

    private String patente;
    private String fechaVTV;
    private String marca;
    private String modelo;
    private String color;

    public Vehiculo(String patente, String fechaVTV, String marca, String modelo, String color) {
        this.patente = patente;
        this.fechaVTV = fechaVTV;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getPatente() {
        return patente;
    }

    public String getFechaVTV() {
        return fechaVTV;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + color + " (patente " + patente + ")";
    }
}
