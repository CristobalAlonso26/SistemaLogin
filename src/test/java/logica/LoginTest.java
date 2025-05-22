package logica;

import data.DatosLogin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    private Login login;
    private DatosLogin datos;
    @BeforeEach
            void setup(){
        login = new Login();
        try{
        datos = new DatosLogin();} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    LoginTest() throws IOException {
    }

    @Test
    void ValidacionCorrecta() {
        assertTrue(login.autenticar("xiao", "ola123", datos));
        }
    @Test
    void ValidacionUsuarioNoExistente() {
        assertFalse(login.autenticar("sdgfa","dbfgsdfa",datos));
    }
    @Test
    void ValidacionContraseniaNoValida(){
        assertFalse(login.autenticar("xiao","fgdsfa",datos));
    }
    @Test
    void UsuarioRepetido(){
        assertTrue(login.autenticar("xiao","ola123",datos));
    }
    @Test
    void IngresoContraseniaYUsuario(){
        assertFalse(login.autenticar("ola123","xiao",datos));
    }
    }
