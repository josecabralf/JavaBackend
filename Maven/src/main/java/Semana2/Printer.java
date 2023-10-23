package Semana2;

public class Printer {
    public static void printCuadrado(int n, char c){
        for(int i = 0; i < n; i++){
            lineaCuadrada(n, c);
        }
    }

    private static void lineaCuadrada(int n, char c) {
        for(int j = 0; j < n*2; j++){
            System.out.print(' ');
            if (j % 2 == 0){
                System.out.print(c);
            }
        }
        System.out.println();
    }

    public static void printOlaCuadrada(int n, char c){
        for(int i = 0; i < n; i++){
            if (i%2 == 1){
                System.out.print(' ');
            }
            lineaCuadrada(n, c);
        }
    }

    public static void printTriangulo(int n, char c){
        for(int i = 0; i < n; i++){
            for (int j = 0; j < i+1; j++){
                System.out.print(' ');
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printOlaTriangular(int n, char c){
        printTriangulo(n, c);
        for (int i = n-1; i > -1; i--){
            for (int j = 0; j < i; j++){
                System.out.print(' ');
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
