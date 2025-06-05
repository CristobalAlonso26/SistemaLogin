package data;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DatosLogin {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    File archivo = new File("src/main/resources/login.txt");
    public DatosLogin() throws IOException{
            validacionArchivo(archivo);
            cargarUsuarios();

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void validacionArchivo(File archivo) throws IOException {
        if(!archivo.exists()){
            throw new IOException("excepcion el archivo no existe");
        }
    }

    private void cargarUsuarios() {
        try(BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(Validadorlineas(linea)){
                    String[] elementos = SeparadorLineas(linea);
                    usuarios.add(new Usuario(elementos[0],elementos[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("error al leer el archivo"+ e.getMessage());
        }

    }

    private Boolean Validadorlineas(String linea){

        if(!linea.isEmpty()){
            String regex = "^[^ ;]+;[^ ;]+$";
            return Pattern.matches(regex,linea.trim());
        }
        return false;
    }
    private String[] SeparadorLineas(String linea){
        return linea.trim().split(";");
    }

}