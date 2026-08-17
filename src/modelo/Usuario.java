package modelo;

public abstract class Usuario {

    private String usuario;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private int dni;
    private String mail;
    private BilleteraVirtual billetera;

    protected Usuario(String usuario, String contrasenia, String nombre, String apellido, int dni, String mail) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
    }

    public void crearCuenta(CuentaDTO cuenta) {
        this.usuario = cuenta.getUsuario();
        this.contrasenia = cuenta.getContrasenia();
        this.nombre = cuenta.getNombre();
        this.apellido = cuenta.getApellido();
        this.dni = cuenta.getDni();
        this.mail = cuenta.getMail();
    }

    public boolean iniciarSesion(CuentaDTO cuenta) {
        return usuario.equals(cuenta.getUsuario()) && contrasenia.equals(cuenta.getContrasenia());
    }

    protected void setBilletera(BilleteraVirtual billetera) {
        this.billetera = billetera;
    }

    public BilleteraVirtual getBilletera() {
        return billetera;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }
}
