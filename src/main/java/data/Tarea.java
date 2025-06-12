package data;

/**
 * Representa una tarea individual del usuario.
 */
public class Tarea {
    private String descripcion;
    private final int ID;
    private final Prioridad prioridad;
    private boolean finalizada = false;
    private HistorialSesion historialSesion = new HistorialSesion(java.time.LocalDateTime.now());
    /**
     * Constructor que inicializa la descripción de la tarea.
     * @param descripcion contenido de la tarea
     */
    public Tarea(int ID ,String descripcion, Prioridad prioridad) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
    public Tarea(int ID, String descripcion, Prioridad prioridad, boolean finalizada) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.finalizada = finalizada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getID() {
        return ID;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void marcarFinalizada(){
        finalizada = true;
    }
    public boolean estaFinalizada(){
        return finalizada;
    }

    @Override
    public String toString() {
        return  getDescripcion() + ";" + prioridad + ";" + finalizada;
    }
}
