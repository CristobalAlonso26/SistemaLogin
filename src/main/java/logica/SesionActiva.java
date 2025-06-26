package logica;

import data.*;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios;

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
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
    private void mostrarOpcionesSesion() {
        System.out.println("=====MENU SESIÓN====");
        System.out.println("1. Escribir tareas");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. salir de la sesión");
        if(usuario.getNombre().equals("admin")){
            System.out.println("4. Registrar usuarios");
        }
        System.out.println("5. Editar Tarea");
        System.out.println("6. Mostrar tareas activas");
        System.out.println("7. Obtener tareas finalizadas");
        System.out.println("8. finalizar tarea");
    }

    private void ejecutarOpcion(String opcion) {
        switch (opcion){
            case "1"-> ingresarTarea();
            case "2" -> {
                for (Tarea t : datosSesion.getTareas()){
                    System.out.println(t.getID() +".- " + t.toString());
                }}
            case "3"-> System.out.println("saliendo....");
            case "4"-> {
                if(usuario.getNombre().equals("admin")) registrarUsuario();
                else System.out.println("ingrese una opción valida");
            }
            case "5"-> EditarTarea();
            case "6"-> System.out.println(datosSesion.mostrarTareasActivas());
            case "7"-> System.out.println(datosSesion.mostrarTareasFinalizadas());
            case "8"-> {
                datosSesion.finalizarTarea(ObtenerNumero());
                System.out.println("Tarea finalizada");
            }
            default -> System.out.println("ingrese una opción valida");
        }
    }
    private String obtenerOpcion(){
        return scanner.nextLine();
    }

    private void ingresarTarea() {
        System.out.println("Ingrese una tarea: ");
        String tarea= scanner.nextLine();
        Prioridad prioridad = obtenerPrioridad();
        datosSesion.EscribirTarea(tarea,prioridad);
    }
    private Prioridad obtenerPrioridad(){
        System.out.println("ingrese la prioridad de la tarea (BAJA, MEDIA, ALTA):");
        String prioridad = scanner.nextLine().toUpperCase().trim();
        while (true){
            try {
                return Prioridad.valueOf(prioridad);
            }catch (IllegalArgumentException e){
                System.out.println("Ingrese una prioridad valida");
                prioridad = scanner.nextLine().toUpperCase().trim();
            }
        }
    }

    // cambiar esto a algo con objeto usuario maybe

    private void registrarUsuario() {
        System.out.println("ingrese nuevo usuario");
        String nuevoUsuario = scanner.nextLine().toLowerCase().trim();
        System.out.println("ingrese su nueva contraseña");
        String nuevaContrasenia = scanner.nextLine().toLowerCase().trim();
        if (gestorUsuarios.registrar(nuevoUsuario,nuevaContrasenia)){
            System.out.println("Registro exitoso");
        }
    }
    private void EditarTarea(){
        System.out.println("ingrese el ID de la tarea que desea cambiar");
        int ID = ObtenerNumero();
        System.out.println("ingrese la nueva descripción de la tarea");
        String newDescription = scanner.nextLine();
        datosSesion.EditarTareaporID(ID,newDescription);
    }

    private int ObtenerNumero(){
        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1;
        }
        return opcion;
    }

}