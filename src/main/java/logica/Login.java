package logica;

import data.DatosLogin;
import data.Perfil;
import data.Usuario;

import java.util.ArrayList;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    /**
     * Verifica si existe una línea con el formato exacto "usuario; clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @param datos objeto DatosLogin que contiene la lista de credenciales
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        for (Usuario u : datos.getUsuarios()){
            if(u.getNombre().equals(usuario) && u.getClave().equals(clave)){
                return true;
            }
        }
        return false;
    }
    public Usuario obtenerusuario(String usuario, String clave, DatosLogin datos){
        for (Usuario u : datos.getUsuarios()){
            if(u.getNombre().equals(usuario) && u.getClave().equals(clave)){
                return u;
            }
        }
        return new Usuario(usuario,clave,new Perfil("generico@ufromail.cl"));
    }

}
