package empleados;

public class Coche {
    //Atributos:
    private String matricula;
    private String marca;
    private String modelo;
    
    //Constructores:
    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    //Metodos:
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "\nCOCHE:\n Matricula: " + matricula + " Marca: " + marca + " Modelo: " + modelo;
    }
   
}
