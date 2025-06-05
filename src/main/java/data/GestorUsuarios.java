package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private final File archivo;

    public GestorUsuarios() {
        archivo = new File("src/main/resources/login.txt");
        try {if(!archivo.exists()){
            archivo.createNewFile();
        }}catch (IOException e){
            System.out.println("vdbsklajdñk" + e.getMessage());
        }

    }

    public boolean registrar(String usuario, String clave) {
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true))){
            escritor.write(usuario + ";" + clave);
            escritor.newLine();
            escritor.flush();
            return true;
        }catch (IOException e){
            System.out.println("error al registrar el usuario" + e.getMessage());
            return false;
        }
    }
}