package logica;

import data.DatosSesion;
import data.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final String usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios;

    public SesionActiva(String usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario);
        this.gestorUsuarios = new GestorUsuarios();
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        String opcion;
        do {
            mostrarOpcionesSesion();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (!opcion.equals("3"));
    }
    public void mostrarOpcionesSesion() {
        System.out.println("=====MENU SESIÓN====");
        System.out.println("1. Escribir tareas");
        System.out.println("2. Mostrar tareas");
        System.out.println("3.salir de la sesión");
        if(usuario.equals("admin")){
            System.out.println("4. registrar usuarios");
        }
    }

    private void ejecutarOpcion(String opcion) {
        switch (opcion){
            case "1"-> escribirTarea();
            case "2"-> datosSesion.LeerTarea();
            case "3"-> System.out.println("saliendo....");
            case "4"-> {
                if(usuario.equals("admin")) registrarUsuario();
                else System.out.println("ingrese una opción valida");
            }
            default -> System.out.println("ingrese una opción valida");
        }
    }
    private String obtenerOpcion(){
        return scanner.nextLine();
    }

    private void escribirTarea() {
        System.out.println("ingrese una tarea: ");
        String tarea = scanner.nextLine();
        datosSesion.EscribirTarea(tarea);
    }

    private void registrarUsuario() {
        System.out.println("ingrese nuevo usuario");
        String nuevoUsuario = scanner.nextLine().toLowerCase().trim();
        System.out.println("ingrese su nueva contraseña");
        String nuevaContraseña = scanner.nextLine().toLowerCase().trim();
        gestorUsuarios.registrar(nuevoUsuario,nuevaContraseña);
    }
}