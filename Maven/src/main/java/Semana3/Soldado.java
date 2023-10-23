package Semana3;

import Semana3.Persona;

public class Soldado extends Persona {
    public Soldado(int dni, String nombre) {
        super(dni, nombre);
    }

    @Override
    public void saludar(){
        System.out.println("SEÑOR, SI, SEÑOR!");
    }
}
