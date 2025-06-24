package app;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WelcomeScreenGUI {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void mostrarVentana() {
        // Crear el JFrame
        JFrame frame = new JFrame("Pantalla de Bienvenida");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel principal con un layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Mensaje de bienvenida
        String idioma = config.getLanguage().toUpperCase();
        String mensajeBienvenida;
        if (idioma.equals("ES")) {
            mensajeBienvenida = "¡Bienvenido al sistema!";
        } else {
            mensajeBienvenida = "Welcome to the system!";
        }

        // Crear un JLabel para el mensaje de bienvenida
        JLabel lblBienvenida = new JLabel(mensajeBienvenida);
        lblBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblBienvenida);

        // Formatear y mostrar la hora actual
        JLabel lblHora = new JLabel("Hora actual: " + obtenerHoraActual(config.getTimeFormat()));
        lblHora.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblHora);

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton(idioma.equals("EN") ? "Close" : "Cerrar");
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.addActionListener(e -> frame.dispose()); // Cerrar ventana
        panel.add(btnCerrar);

        // Añadir panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para obtener la hora actual formateada
    private String obtenerHoraActual(String formato) {
        LocalTime ahora = LocalTime.now();
        if ("AM/PM".equalsIgnoreCase(formato)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            return ahora.format(formatter);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return ahora.format(formatter);
        }
    }
}

