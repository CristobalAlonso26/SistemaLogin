package gui;
import data.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class MainView extends JFrame {
    private final Usuario usuario;
    private final DatosSesion datosSesion;
    private DefaultListModel<String> tareasModel;
    private JList<String> tareasList;
    private JTextField filtroField;

    public MainView(Usuario usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
        setTitle("Tareas de" + usuario.getNombre());
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
        cargarTareas();
    }

    private void inicializarComponentes() {
        // Panel principal con distribuci ón BorderLayout .
        // Norte , Sur , Centro , Este y Oeste .
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tareasModel = new DefaultListModel<>();
        tareasList = new JList<>(tareasModel);
        JScrollPane scrollPane = new JScrollPane(tareasList);

        filtroField = new JTextField();
        // Listener que detecta cuando se escribe en el campo de bú squeda .
        // Cada cambio actualiza autom á ticamente la lista filtrada .
        filtroField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }

            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }

            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel(" Buscar : "), BorderLayout.WEST);
        topPanel.add(filtroField, BorderLayout.CENTER);
        JButton agregarBtn = new JButton(" Agregar Tarea ");
        agregarBtn.addActionListener(e -> mostrarDialogoAgregar());
// Agregar los componentes al panel principal en sus respectivas zonas .
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(agregarBtn, BorderLayout.SOUTH);
        add(panel);
    }

    private void filtrar() {
        // Obtener texto del usuario a minú sculas
        String texto = filtroField.getText().toLowerCase();
        tareasModel.clear();
        for (Tarea tarea : usuario.getTareas()) {
            // Si la descripci ón de la tarea contiene el texto buscado
            if (tarea.getDescripcion().toLowerCase().contains(texto)) {
                tareasModel.addElement(
                        "[" +
                                tarea.getPrioridad() +
                                "] "
                                + tarea.getDescripcion()
                );
            }
        }
    }

    private void mostrarDialogoAgregar() {
        JTextField descField = new JTextField();
        String[] opciones = {"BAJA", "MEDIA", "ALTA"};
        JComboBox<String> prioridadBox = new JComboBox<>(opciones);
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel(" Descripcion:"));
        panel.add(descField);
        panel.add(new JLabel(" Prioridad :"));
        panel.add(prioridadBox);
        // Ventana de diá logo para ingresar datos
        int resultado = JOptionPane
                .showConfirmDialog(
                        this,
                        panel,
                        " Agregar Tarea ",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );
        // Si el usuario presiona OK
        if (resultado == JOptionPane.OK_OPTION) {
            String desc = descField.getText();
            String prio = (String) prioridadBox.getSelectedItem();
            if (!desc.isBlank() && prio != null) {
                datosSesion.EscribirTarea(desc, Prioridad.valueOf(prio.toUpperCase()));
                cargarTareas();
            }
        }
    }
    private void cargarTareas () {
        tareasModel . clear ();
        for (Tarea tarea : usuario.getTareas ()) {
            tareasModel . addElement (
                    "[" +
                            tarea . getPrioridad () +
                            "] " +
                            tarea . getDescripcion ()
            );
        }
    }

}



