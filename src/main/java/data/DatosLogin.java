package data;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    File archivo = new File("src/main/java/data/login.txt");
    public DatosLogin(){
        cargarUsuarios();
    }
    private void cargarUsuarios() {
        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(Validadorlineas(linea)){
                    credenciales.add(linea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("la base de datos se ha desintegrado");
        } catch (IOException e) {
            throw new RuntimeException("error al leer el archivo");
        }

    }
    private Boolean Validadorlineas(String linea){

        if(!linea.isEmpty()){
            String regex = "^[^ ;]+;[^ ;]+$";
            return Pattern.matches(regex,linea);
        }
        return false;
    }
}