package data;

import java.io.*;
import java.util.ArrayList;

public class DatosSesion {
    private final File archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    public DatosSesion(String usuario) {
        this.archivo = new File("src/main/resources/" + usuario + "_todo.txt");
        VerificarArchivo();
        CargarTarea();
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    private Boolean VerificarArchivo() {
        try{
            return archivo.createNewFile();
        } catch (IOException e){
            System.out.println("NO S E PUDO CREAR EL ARCHIVO" + e.getMessage());
            return false;
        }
    }

    private void GuardarTarea(){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))){
            for( Tarea t : tareas){
                escritor.write(t.getDescripcion());
                escritor.newLine();
            }
        }catch (IOException e){
            System.out.println("error al ingresar tarea" + e.getMessage());

    }}
    public void EscribirTarea(String tarea){
        tareas.add(new Tarea(tarea, Prioridad.ALTA));
        GuardarTarea();
    }

    public void CargarTarea(){
        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                tareas.add(new Tarea(linea, Prioridad.ALTA));
            }
        } catch (IOException e) {
            System.out.println("error al leer el archivo"+ e.getMessage());
        }
    }
    public void EditarTareaporID(int ID, String newdescription ){
        for (Tarea t : tareas){
            if(t.getID()==ID){
                t.setDescripcion(newdescription);
            }
        }
    }

}
