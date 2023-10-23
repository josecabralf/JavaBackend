package Semana3;

public class Persona {
    private  int dni;
    private String nombre;
    public void saludar(){
        System.out.println("Hola!");
    }
    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{ dni=" + dni + ", nombre='" + nombre + '\'' + " }";
    }
}
