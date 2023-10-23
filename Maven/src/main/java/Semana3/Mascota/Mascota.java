package Semana3.Mascota;

public class Mascota {
    // Atributos:
    private final String nombre;
    private int energia;
    private int humor;
    private final EstadoMascota estado;

    public Mascota(String nombre) {
        this.energia = 100;
        this.humor = 5;
        this.estado = new EstadoMascota();
        this.nombre = nombre;
    }

    public void incrementarEnergia(int en){
        this.energia += en;
        if (this.energia > 100) this.energia = 100;
    }
    public void incrementarHumor(int h){
        this.humor += h;
        if (this.humor > 5) this.humor = 5;
        else if (this.humor < 0) this.humor = 0;
    }
    private void accion(int en, int h){
        incrementarEnergia(en);
        incrementarHumor(h);
    }

    // Comportamientos de Ingesta
    private boolean ingerir(int en){
        if (this.estaInactiva()) {
            System.out.println(this.nombre + " no puede hacer lo que le pides. Está " + this.estado.getNombre() + "...");
            return false;
        }
        this.estado.ingesta();
        System.out.println("Ves como la panza de " + this.nombre + " incrementa su tamaño");
        if (this.estado.getIngestaConsecutiva() == 5) {
            System.out.println(this.nombre + " murió de obesidad...");
            this.morir();
        }
        else if (this.estado.getIngestaConsecutiva() >= 3) {
            System.out.println(this.nombre + " se está volviendo obeso...");
            accion(en, -1);
        }
        else {
            accion(en, 1);
        }
        return true;
    }

    private void morir() {
        this.energia = 0;
        this.humor = 0;
        this.estado.morir();
    }

    public boolean comer(){
        System.out.println("Quieres que " + this.nombre + " coma un McDonald's...");
        return ingerir(this.energia/10);
    }
    public boolean beber(){
        System.out.println("Quieres que " + this.nombre + " beba Fernet...");
        return ingerir(this.energia/20);
    }

    // Comportamientos de Actividad
    private boolean mover(double porc){
        if (this.estaInactiva()) {
            System.out.println(this.nombre + " no puede hacer lo que le pides. Está " + this.estado.getNombre() + "...");
            return false;
        }
        double en = -((double) this.energia * porc);
        accion((int) en, -2);
        this.estado.actividad();
        System.out.println(this.nombre + " mueve su panza...");
        if (this.estado.getActividadConsecutiva() == 3) {
            System.out.println(this.nombre + " se cansó de hacer ejercicio...");
            return dormir();
        }
        return true;
    }
    public boolean correr(){
        System.out.println("Quieres que " + this.nombre + " corra para bajar su panza...");
        return mover(0.35);
    }
    public boolean saltar(){
        System.out.println("Quieres que " + this.nombre + " salte para bajar su panza...");
        return mover(0.15);
    }

    // Otros comportamientos
    public boolean dormir(){
        if (this.estado.isMuerto()){
            System.out.println(this.nombre + " duerme, pero su sueño durará para siempre...");
            return false;
        }
        else if (!this.estado.isDormido()) {
            System.out.println(this.nombre + " se fue a mimir...");
            this.estado.otra();
            accion(25, 2);
            return true;
        }
        System.out.println(this.nombre + " ya está mimiendo...");
        return false;
    }
    public boolean despertar(){
        if (this.estado.isDormido()){
            System.out.println("Despertaste a " + this.nombre + "... Se lo ve con resaca...");
            this.estado.otra();
            incrementarHumor(-1);
            return true;
        }
        else if (this.estado.isMuerto()) {
            System.out.println("Intentas despertar a " + this.nombre + "... No respira...");
            return false;
        }
        System.out.println(this.nombre + " ya está despierto...");
        return false;
    }
    private boolean estaInactiva(){
        return (this.estado.isMuerto() || this.estado.isDormido());
    }


    // toString
    @Override
    public String toString() {
        return  this.nombre + "\n" +
                "Energia: " + this.energia + "\n" +
                "Humor: " + this.humor + "\n" +
                "Estado: " + this.estado.getNombre();
    }
}
