package logica;

import data.DatosLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
    void ValidacionCorrecta() {
        Login login = new Login();
        DatosLogin datos = new DatosLogin();
            assertTrue(login.autenticar("xiao", "ola123", datos));
        }
    }
}