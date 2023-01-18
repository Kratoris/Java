package empleados;

public class Supervisor extends Empleado{
    //Constructores:
    public Supervisor() {
    }

    public Supervisor(String nombre, String apellido, String direccion, int dni, int antiguedad, int telefono, double salario) {
        super(nombre, apellido, direccion, dni, antiguedad, telefono, salario);
    }
    
    //Metodos:
    @Override
    public void imprimir() {
        String mensaje;
        
        mensaje = "\nSUPERVISOR: \nNombre: " + super.getNombre() + " Apellido: " + super.getApellido() + " Direccion: "
                + super.getDireccion() + " DNI: " + super.getDni() + " Telefono: " + super.getTelefono() + " Salario "
                + super.getSalario() + " Anios de antiguedad: " + super.getAntiguedad();
        
        System.out.println(mensaje);
    }

    @Override
    public void incrementoSalario() { }
    
}
