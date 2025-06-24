package app;

import javax.swing.*;

public class GUIConfigViewer {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void mostrarConfiguracionEnVentana() {
        String idioma = config.getLanguage().toUpperCase();

        // Etiquetas traducidas
        String titulo = idioma.equals("EN") ? "Current Configuration" : "Configuración Actual";
        String moneda = idioma.equals("EN") ? "Default currency" : "Moneda por defecto";
        String hora = idioma.equals("EN") ? "Time format" : "Formato de hora";
        String conexiones = idioma.equals("EN") ? "Max connections" : "Máx. conexiones";
        String lenguaje = idioma.equals("EN") ? "Language" : "Idioma";
        String autosave = idioma.equals("EN") ? "Auto-save interval (min)" : "Intervalo de auto guardado";
        String logs = idioma.equals("EN") ? "Enable logs" : "Logs habilitados";
        String tema = idioma.equals("EN") ? "Theme" : "Tema";
        String region = idioma.equals("EN") ? "Region" : "Región";
        String respaldo = idioma.equals("EN") ? "Backup enabled" : "Respaldos automáticos";
        String rutaRespaldo = idioma.equals("EN") ? "Backup directory" : "Ruta de respaldo";

        // Construir texto
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(titulo).append(" ===\n");
        sb.append(moneda).append(": ").append(config.getDefaultCurrency()).append("\n");
        sb.append(hora).append(": ").append(config.getTimeFormat()).append("\n");
        sb.append(conexiones).append(": ").append(config.getMaxConnections()).append("\n");
        sb.append(lenguaje).append(": ").append(config.getLanguage()).append("\n");
        sb.append(autosave).append(": ").append(config.getAutoSaveInterval()).append("\n");
        sb.append(logs).append(": ").append(config.isEnableLogs()).append("\n");
        sb.append(tema).append(": ").append(config.getTheme()).append("\n");
        sb.append(region).append(": ").append(config.getRegion()).append("\n");
        sb.append(respaldo).append(": ").append(config.isBackupEnabled()).append("\n");
        sb.append(rutaRespaldo).append(": ").append(config.getBackupDirectory()).append("\n");

        // Mostrar en ventana
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(350, 250));

        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

