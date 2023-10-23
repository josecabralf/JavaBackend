package Semana3.Mascota;

import java.util.Objects;

public class EstadoMascota {
    private int ingestaConsecutiva;
    private int actividadConsecutiva;
    private String ultimaAccion;
    private boolean dormido;
    private boolean muerto;
    private String nombre;

    public EstadoMascota() {
        this.ingestaConsecutiva = 0;
        this.actividadConsecutiva = 0;
        this.ultimaAccion = null;
        this.dormido = false;
        this.muerto = false;
        this.nombre = "despierto";
    }
    public void ingesta() {
        if (!Objects.equals(this.ultimaAccion, "ingesta")){
            this.ultimaAccion = "ingesta";
            this.ingestaConsecutiva = 1;
        }
        else this.ingestaConsecutiva += 1;
    }
    public void actividad() {
        if (!Objects.equals(this.ultimaAccion, "actividad")){
            this.ultimaAccion = "actividad";
            this.actividadConsecutiva = 1;
        }
        else this.actividadConsecutiva += 1;
    }

    public void otra(){
        this.ultimaAccion = "otra";
        if (this.dormido) {
            this.dormido = false;
            this.nombre = "despierto";
        }
        else {
            this.dormido = true;
            this.nombre = "dormido";
        }
    }

    public boolean isDormido() {
        return dormido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public int getIngestaConsecutiva() {
        return ingestaConsecutiva;
    }

    public int getActividadConsecutiva() {
        return actividadConsecutiva;
    }

    public String getNombre() {
        return nombre;
    }

    public void morir() {
        this.muerto = true;
        this.nombre = "muerto";
    }
}
