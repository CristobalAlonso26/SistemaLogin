package gui;

import data.DatosLogin;
import data.Usuario;
import logica.Login;
import logica.SesionActiva;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner sc = new Scanner(System.in);
    DatosLogin datos;
    Login login = new Login();

    public ConsolaLogin() throws IOException {
        this.datos = new DatosLogin();
    }
    /**
     * Controla el ciclo principal del menú del sistema.
     */

    public void menu() {
        String opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (!opcion.equals("2"));
    }

    private void mostrarOpciones() {
        System.out.println("          LOGIN       ");
        System.out.println("1. Iniciar sesión  ");
        System.out.println("2. Salir");
        System.out.println("Ingrese su opción: ");
        // TODO: Mostrar "1. Iniciar sesión", "2. Salir"
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(String opcion) {
        switch (opcion){
            case "1"-> {
                String nombre = obtenerUsuario();
                String contrasenia = obtenerContrasenia();
                if (manejarLogin(nombre, contrasenia)) {
                    Usuario u = login.obtenerusuario(nombre,contrasenia,datos);
                    SesionActiva sesion = new SesionActiva(u);
                    sesion.menuSesion();
                }
            }
            case "2"-> System.out.println("Saliendo del programa...");
            default -> System.out.println("ingrese una opción valida");
        }
    }

    private String obtenerOpcion(){
        return sc.nextLine();
    }
    private boolean manejarLogin(String usuario,String contrasenia) {
        if(login.autenticar(usuario,contrasenia,datos)){
            System.out.println("Su cuenta ha sido autenticada correctamente");
            return true;
        }else{
            System.out.println("Usted no es Usuario");
            return false;
        }
        // TODO: Pedir usuario y contraseña por consola
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
    }
    private String obtenerUsuario(){
        System.out.println("Ingrese su usuario");
        return sc.nextLine().toLowerCase().trim();
    }
    private String obtenerContrasenia(){
        System.out.println("Ingrese su contraseña");
        return sc.nextLine().toLowerCase().trim();
    }
    private String obtenerCorreo(){
        System.out.println("Ingrese su correo");
        return sc.nextLine().toLowerCase().trim();
    }
}
