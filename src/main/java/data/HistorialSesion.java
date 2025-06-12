package data;

import java.time.LocalDateTime;

public class HistorialSesion {
    private LocalDateTime inicio;
    private int tareasAgregadas;

    public HistorialSesion(LocalDateTime inicio) {
        this.inicio = inicio;
        this.tareasAgregadas = 1;
    }
    public void registrarNuevaTarea(Tarea tarea){
        tareasAgregadas++;
    }

    public int getTareasAgregadas() {
        return tareasAgregadas;
    }

    public LocalDateTime getInicio(){
        return inicio;
    }
}
