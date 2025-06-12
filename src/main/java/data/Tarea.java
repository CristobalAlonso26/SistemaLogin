package data;

/**
 * Representa una tarea individual del usuario.
 */
public class Tarea {
    private String descripcion;
    private final int ID;
    private Prioridad prioridad;
    private static int contador = 1;
    /**
     * Constructor que inicializa la descripción de la tarea.
     * @param descripcion contenido de la tarea
     */
    public Tarea(String descripcion, Prioridad prioridad) {
        this.ID = contador;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        contador++;
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

    @Override
    public String toString() {
        return "Tarea n°" + ID + ": " + getDescripcion() + " " + prioridad;
    }
}
