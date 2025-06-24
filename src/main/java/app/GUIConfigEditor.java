package app;

import javax.swing.*;
import java.awt.*;

public class GUIConfigEditor {

    private final ConfigurationManager config = ConfigurationManager.getInstance();
    private final ConfigCommandHandler handler = new ConfigCommandHandler();

    public void mostrarFormulario() {
        String lang = config.getLanguage().toUpperCase();

        // Traducciones
        String titulo = lang.equals("EN") ? "Edit Configuration" : "Editar Configuración";
        String[] labels = {
                lang.equals("EN") ? "Default currency:" : "Moneda por defecto:",
                lang.equals("EN") ? "Language (ES/EN):" : "Idioma (ES/EN):",
                lang.equals("EN") ? "Time format (24H/AM/PM):" : "Formato de hora (24H/AM/PM):",
                lang.equals("EN") ? "Max connections:" : "Máx. conexiones:",
                lang.equals("EN") ? "Auto-save interval (min):" : "Intervalo de auto guardado (min):",
                lang.equals("EN") ? "Enable logs (true/false):" : "Activar logs (true/false):",
                lang.equals("EN") ? "Theme (light/dark):" : "Tema (light/dark):",
                lang.equals("EN") ? "Region:" : "Región:",
                lang.equals("EN") ? "Enable backup (true/false):" : "Activar respaldo (true/false):",
                lang.equals("EN") ? "Backup directory:" : "Ruta de respaldo:"
        };

        // Campos precargados
        JTextField[] fields = {
                new JTextField(config.getDefaultCurrency()),
                new JTextField(config.getLanguage()),
                new JTextField(config.getTimeFormat()),
                new JTextField(String.valueOf(config.getMaxConnections())),
                new JTextField(String.valueOf(config.getAutoSaveInterval())),
                new JTextField(String.valueOf(config.isEnableLogs())),
                new JTextField(config.getTheme()),
                new JTextField(config.getRegion()),
                new JTextField(String.valueOf(config.isBackupEnabled())),
                new JTextField(config.getBackupDirectory())
        };

        JPanel panel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(fields[i]);
        }

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                titulo,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                handler.cambiarMoneda(fields[0].getText().trim());
                handler.cambiarIdioma(fields[1].getText().trim().toUpperCase());
                handler.cambiarFormatoHora(fields[2].getText().trim());
                handler.cambiarMaxConexiones(Integer.parseInt(fields[3].getText().trim()));
                handler.cambiarIntervaloAutoGuardado(Integer.parseInt(fields[4].getText().trim()));
                handler.cambiarLogs(Boolean.parseBoolean(fields[5].getText().trim()));
                handler.cambiarTema(fields[6].getText().trim());
                handler.cambiarRegion(fields[7].getText().trim());
                handler.cambiarRespaldo(Boolean.parseBoolean(fields[8].getText().trim()));
                handler.cambiarRutaRespaldo(fields[9].getText().trim());

                JOptionPane.showMessageDialog(null,
                        lang.equals("EN") ? "Configuration updated successfully!" : "¡Configuración actualizada!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        lang.equals("EN") ? "Invalid input. Please try again." : "Entrada inválida. Intenta de nuevo.",
                        "⚠️ Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

