
package GestionUsuario.modelo;


public class Usuario {

    protected String codigo_Ciudad;
    protected String nombres;
    protected String apellido1;
    protected String apellido2;
    protected String telefono;
    protected String direccion;
    protected String correo;
    protected String estado;

    public Usuario() {
    }

    public Usuario(String codigo_Ciudad, String nombres, String apellido1, String apellido2, String telefono, String direccion, String correo, String estado) {
        this.codigo_Ciudad = codigo_Ciudad;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.estado = estado;
    }

    public String getCodigo_Ciudad() {
        return codigo_Ciudad;
    }

    public void setCodigo_Ciudad(String codigo_Ciudad) {
        this.codigo_Ciudad = codigo_Ciudad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
