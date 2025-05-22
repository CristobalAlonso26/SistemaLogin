package data;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    File archivo = new File("src/main/java/data/login.txt");
    public DatosLogin(){
        validacionArchivo(archivo);
        cargarUsuarios();
    }
    public void validacionArchivo(File archivo){
        if(!archivo.exists()){
            System.out.println("la base de datos exploto, el sistema no puede funcionar");
            System.exit(1);
        }
    }
    private void cargarUsuarios() {
        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(Validadorlineas(linea)){
                    credenciales.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("error al leer el archivo");
        }

    }
    private Boolean Validadorlineas(String linea){

        if(!linea.isEmpty()){
            String regex = "^[^ ;]+;[^ ;]+$";
            return Pattern.matches(regex,linea.trim());
        }
        return false;
    }
}