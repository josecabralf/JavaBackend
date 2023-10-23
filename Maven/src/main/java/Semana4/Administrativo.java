package Semana4;

public class Administrativo extends Empleado{
    private boolean presentismo;
    public Administrativo(String nombre, String apellido, double sueldoMensual, boolean presentismo) {
        super(nombre, apellido, sueldoMensual);
        this.presentismo = presentismo;
    }

    public double cobrar(){
        double cobrado = (presentismo)? this.getSueldoMensual()*1.15 : this.getSueldoMensual();
        return cobrado;
    }

    public boolean isPresentismo() {
        return presentismo;
    }

    public void setPresentismo(boolean presentismo) {
        this.presentismo = presentismo;
    }
}
