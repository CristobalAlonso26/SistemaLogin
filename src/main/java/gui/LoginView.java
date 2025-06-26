package gui;
import javax.swing.*;
import java.awt.*;

import data.DatosLogin;
import data.Usuario;
import logica.Login;

public class LoginView extends JFrame {
    private final JPanel panel = new JPanel();
    private final JTextField usuario = new JTextField(30);
    private final JPasswordField contrasenia = new JPasswordField(30);
    private final JButton iniciarSesion = new JButton("Iniciar Sesión");
    private final JButton salir = new JButton("Salir");
    private final JLabel titulo = new JLabel("Login");
    private final JLabel usuarioLabel = new JLabel("Usuario:");
    private final JLabel contraseniaLabel = new JLabel("Contraseña:");
    private JLabel error = new JLabel("");
    private DatosLogin datos = new DatosLogin();

    public LoginView() {
        panel.setLayout(new GridLayout(3,2,5, 2));
        setTitle (" Login ");
        setSize (300 , 200);
        setDefaultCloseOperation ( EXIT_ON_CLOSE );
        setLocationRelativeTo ( null );
        panel .add( usuarioLabel );
        panel .add( usuario );
        panel .add( contraseniaLabel );
        panel .add( contrasenia );
        panel .add( new JLabel ());
        panel .add( iniciarSesion );
        add(panel);
        iniciarSesion.addActionListener(e ->autenticarUsuario() );
    }

    private void autenticarUsuario() {
        Login login = new Login();
        String nombre = usuario.getText();
        String contrasenia = new String(this.contrasenia.getPassword());
        if (login.autenticar(nombre,contrasenia,datos)) {
            Usuario u = login.obtenerusuario(nombre,contrasenia,datos);
            new MainView(u).setVisible(true);
            this.dispose();
        } else {
            JOptionPane . showMessageDialog (
                    this ,
                    " Usuario no registrado ",
                    " Error ",
                    JOptionPane . ERROR_MESSAGE
            );

        }

    }
}
