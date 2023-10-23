package Semana3.Mascota;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class programaMascota {
    public static String menu(){
        System.out.println("Qué deseas hacer con Pipi");
        System.out.println("1. Comer");
        System.out.println("2. Beber");
        System.out.println("3. Correr");
        System.out.println("4. Saltar");
        System.out.println("5. Dormir");
        System.out.println("6. Despertar");
        System.out.println("7. Ver Datos");
        System.out.println("8. Salir");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String op;
        try {
            System.out.print("Seleccione una opcion: ");
            op = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return op;
    }

    public static void mainMascota() {
        Mascota m = new Mascota("Pipi");
        while (true){
            String op = menu();
            if (Objects.equals(op, "1")) m.comer();
            else if (Objects.equals(op, "2")) m.beber();
            else if (Objects.equals(op, "3")) m.correr();
            else if (Objects.equals(op, "4")) m.saltar();
            else if (Objects.equals(op, "5")) m.dormir();
            else if (Objects.equals(op, "6")) m.despertar();
            else if (Objects.equals(op, "7")) System.out.println(m);
            else if (Objects.equals(op, "8")) break;
        }
    }
}