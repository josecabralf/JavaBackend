package org.ejemplo;

public class Perro {
    private static int  nroPatas = 4;

    public  static void definir(){
        System.out.println("org.ejemplo.Perro: animal mamifero de "+ nroPatas + " patas...");
        System.out.println("Sabe ladrar");
    }

    public void ladrar(){
        System.out.println("Arf Arf Arf...");
    }

    public int getNroPatas() {
        return nroPatas;
    }
}
