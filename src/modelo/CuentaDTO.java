package modelo;

public class CuentaDTO {

    private String usuario;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private int dni;
    private String mail;

    public CuentaDTO(String usuario, String contrasenia, String nombre, String apellido, int dni, String mail) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }
}
