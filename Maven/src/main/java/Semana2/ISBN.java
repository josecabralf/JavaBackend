package Semana2;

public class ISBN {
    public static boolean esISBN(String code){
        code = code.replace("-", "");
        char[] cars = code.toCharArray();
        int[] nros = new int[10];
        int sum = 0;
        for(int i = 0; i < cars.length; i++){
            nros[i] = (int)cars[i];
            sum += nros[i]*(cars.length - i);
        }
        if (sum % 11 == 0){
            return true;
        }
        return false;
    }
}
