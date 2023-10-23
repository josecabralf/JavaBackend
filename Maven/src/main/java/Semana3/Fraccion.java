package Semana3;

import org.jetbrains.annotations.NotNull;

public class Fraccion {
    // Atributos
    private int numerador;
    private int denominador;

    public Fraccion(int num, int denom){
        setNumerador(num);
        setDenominador(denom);
    }
    public Fraccion(int num){
        this(num, 1);
    }

    public Fraccion(){
        numerador = 1;
        denominador = 1;
    }

    public Fraccion(@NotNull Fraccion copia){
        this(copia.getNumerador(), copia.getDenominador());
    }

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    private void setDenominador(int denom) {
        if(denom == 0){
            denominador = 1;
        }
        else {
            denominador = denom;
        }
    }
    private void setNumerador(int num) {
        numerador = num;
    }
    public double divisionEntera(){
        return numerador/denominador;
    }
    public double divisionReal(){
        return (double) numerador/(double) denominador;
    }

    @Override
    public String toString(){
        return "(" + this.numerador + "/" + this.denominador + ")";
    }

    public Fraccion sumarA(@NotNull Fraccion f){
        if (this.denominador != f.getDenominador()){
            int denomGral = this.denominador * f.getDenominador();
            int num = this.numerador * f.getDenominador() + f.getNumerador() * this.denominador;
            return new Fraccion(num, denomGral);
        }
        else {
            int num = this.numerador + f.getNumerador();
            return new Fraccion(num, this.denominador);
        }
    }
}
