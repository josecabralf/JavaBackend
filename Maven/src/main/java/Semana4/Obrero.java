package Semana4;

public class Obrero extends Empleado {
    public Obrero(String nombre, String apellido, double sueldoMensual) {
        super(nombre, apellido, sueldoMensual);
    }
    public double cobrar(){
        return this.getSueldoMensual()/20;
    }
}
