package app;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimuladorConexionesGUI {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void iniciarSimulacion() {
        // Crear el JFrame
        JFrame frame = new JFrame("Simulador de Conexiones");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel para mostrar el progreso
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Etiqueta de estado
        JLabel lblEstado = new JLabel("Simulando conexiones...");
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblEstado);

        // Botón de cancelación de simulación
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btnCancelar);

        // Mostrar la cantidad máxima de conexiones
        int maxConexiones = config.getMaxConnections();
        JLabel lblMaxConexiones = new JLabel("Máximo de conexiones: " + maxConexiones);
        lblMaxConexiones.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblMaxConexiones);

        // Campo para mostrar los resultados de la simulación
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        // Agregar todo al frame
        frame.add(panel);
        frame.setVisible(true);

        // Simulación de conexiones (esto podría ir en un hilo para no bloquear la interfaz)
        new Thread(() -> {
            Random rand = new Random();
            int conexionesSimuladas = 0;

            while (conexionesSimuladas < maxConexiones) {
                try {
                    // Simular intento de conexión (éxito o fracaso)
                    boolean exito = rand.nextBoolean();
                    String resultado = exito ? "Conexión exitosa" : "Conexión fallida";
                    String log = "Conexión #" + (conexionesSimuladas + 1) + ": " + resultado;

                    // Actualizar texto en el área de texto
                    SwingUtilities.invokeLater(() -> textArea.append(log + "\n"));

                    conexionesSimuladas++;

                    // Esperar 1 segundo entre cada intento
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Fin de la simulación
            SwingUtilities.invokeLater(() -> lblEstado.setText("Simulación completada"));

        }).start();

        // Acción para cancelar simulación
        btnCancelar.addActionListener(e -> frame.dispose());
    }
}

