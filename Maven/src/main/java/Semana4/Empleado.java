package Semana4;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private double sueldoMensual;

    public Empleado(String nombre, String apellido, double sueldoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombre() {return nombre;}

    public String getApellido() {
        return apellido;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public abstract double cobrar();
}
