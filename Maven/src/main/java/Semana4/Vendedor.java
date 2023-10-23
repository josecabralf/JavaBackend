package Semana4;

public class Vendedor extends Empleado{

    private int totalVendido;
    public Vendedor(String nombre, String apellido, double sueldoMensual, int totalVendido) {
        super(nombre, apellido, sueldoMensual);
        this.totalVendido = totalVendido;
    }

    public double cobrar(){
        double cobrado = this.getSueldoMensual() + ((double) totalVendido) * 0.01;
        return cobrado;
    }

    public int getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(int totalVendido) {
        this.totalVendido = totalVendido;
    }
}
