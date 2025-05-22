package launcher;

import gui.ConsolaLogin;

import java.io.IOException;

public class Inicio {
    public static void main(String[] args) throws IOException {
        ConsolaLogin login = new ConsolaLogin();
        login.menu();
    }
}