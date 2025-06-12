package data;

import java.time.LocalDateTime;

public class HistorialSesion {
    private LocalDateTime inicio;
    private int tareasAgregadas;

    public HistorialSesion(LocalDateTime inicio) {
        this.inicio = inicio;
        this.tareasAgregadas = 0;
    }


    public void registrarNuevaTarea(){
        tareasAgregadas++;
    }

    public int getTareasAgregadas() {
        return tareasAgregadas;
    }

    public LocalDateTime getInicio(){
        return inicio;
    }
}
