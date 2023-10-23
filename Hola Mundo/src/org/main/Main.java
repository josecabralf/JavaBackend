package org.main;

import org.ejemplo.Perro;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al mundo canino");
        System.out.println("Definamos un perro");
        Perro.definir();

        Perro bolt = new Perro();
        bolt.ladrar();
    }
}