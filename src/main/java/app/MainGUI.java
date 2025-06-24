package app;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainGUI {
    private JButton btnVer;
    private JButton btnEditar;
    private JButton btnWelcome;
    private JButton btnSimular;
    private JButton btnSalir;
    private final GUIConfigViewer guiViewer = new GUIConfigViewer();
    private final ConfigCommandHandler configHandler = new ConfigCommandHandler();
    private final WelcomeScreen welcomeScreen = new WelcomeScreen();
    private final ConnectionSimulator simulator = new ConnectionSimulator();
    private final GUIConfigEditor configEditor = new GUIConfigEditor();
    public static void main(String[] args) {
        new MainGUI().crearVentana();
    }

    public void crearVentana() {
        JFrame frame = new JFrame("Configuración Global");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Inicializar botones como atributos
        btnVer = new JButton();
        btnEditar = new JButton();
        btnWelcome = new JButton();
        btnSimular = new JButton();
        btnSalir = new JButton();

        // Asignar acciones
        btnVer.addActionListener(e -> guiViewer.mostrarConfiguracionEnVentana());
        btnEditar.addActionListener(e -> {
            configEditor.mostrarFormulario();
            actualizarTextos();  // << actualizar idioma después de cambiar configuración
        });
        btnWelcome.addActionListener(e -> mostrarWelcomeScreen());  // << Llamar al método para mostrar WelcomeScreen
        btnSimular.addActionListener(e -> iniciarSimulacionConexiones());
        btnSalir.addActionListener(e -> System.exit(0));

        // Agregar botones al panel
        frame.add(btnVer);
        frame.add(btnEditar);
        frame.add(btnWelcome);
        frame.add(btnSimular);
        frame.add(btnSalir);

        // Configurar textos al inicio
        actualizarTextos();

        frame.setVisible(true);
    }
    private void actualizarTextos() {
        String idioma = ConfigurationManager.getInstance().getLanguage().toUpperCase();

        btnVer.setText(idioma.equals("EN") ? "View Configuration" : "Ver Configuración");
        btnEditar.setText(idioma.equals("EN") ? "Edit Configuration" : "Cambiar Configuración");
        btnWelcome.setText(idioma.equals("EN") ? "Welcome Screen" : "Pantalla de Bienvenida");
        btnSimular.setText(idioma.equals("EN") ? "Simulate Connections" : "Simular Conexiones");
        btnSalir.setText(idioma.equals("EN") ? "Exit" : "Salir");
    }
    private void mostrarWelcomeScreen() {
        WelcomeScreenGUI welcomeScreenGUI = new WelcomeScreenGUI();
        welcomeScreenGUI.mostrarVentana();
    }
    private void iniciarSimulacionConexiones() {
        SimuladorConexionesGUI simulador = new SimuladorConexionesGUI();
        simulador.iniciarSimulacion();
    }



}

