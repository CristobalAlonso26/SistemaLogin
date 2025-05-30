package data;

import java.io.*;

public class DatosSesion {
    private static int contador = 1;
    File archivo; // = new File("src/main/resources/" + "usuario" +"_todo.txt");

    public DatosSesion(String usuario) {
        this.archivo = new File("src/main/resources/" + usuario + "_todo.txt");
        VerificarArchivo();
    }

    private Boolean VerificarArchivo() {
        try{if(!archivo.exists()){
            return archivo.createNewFile();
        }
        return true;} catch (IOException e){
            System.out.println("NO S E PUDO CREAR EL ARCHIVO" + e.getMessage());
            return false;
        }
    }

    public void EscribirTarea(String tarea){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))){
            escritor.write(contador+ ". "+ tarea );
            contador++;
            escritor.newLine();
        }catch (IOException e){
            System.out.println("error al ingresar tarea" + e.getMessage());

    }}
    public void LeerTarea(){
        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("error al leer el archivo"+ e.getMessage());
        }

    }

}
