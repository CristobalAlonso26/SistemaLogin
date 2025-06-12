package data;

import java.time.LocalDateTime;

public class Perfil {
    private String correo;
    private LocalDateTime fechaCreacion;

    public Perfil(String correo) {
        this.correo = correo;
        this.fechaCreacion = LocalDateTime.now();
    }
    public String getCorreo() {
        return correo;
    }
    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }
    @Override
    public String toString() {
        return "Perfil{" +
                "correo='" + correo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
