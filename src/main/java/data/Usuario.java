package data;

import java.util.ArrayList;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    private final String nombre;
    private final String clave;
    private final Perfil perfil;
    private ArrayList<Tarea> tareas = new ArrayList<>();

    /**
     * Constructor que inicializa los atributos del usuario.
     *
     * @param nombre nombre del usuario
     * @param clave clave del usuario
     */
    public Usuario(String nombre, String clave, Perfil perfil) {
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", perfil=" + perfil +
                '}';
    }
}