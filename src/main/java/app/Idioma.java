package app;

import java.util.HashMap;
import java.util.Map;

public class Idioma {
    private static final ConfigurationManager config = ConfigurationManager.getInstance();
    private static final Map<String, String> textosES = new HashMap<>();
    private static final Map<String, String> textosEN = new HashMap<>();

    // Variables para almacenar el idioma actual
    private static String idiomaActual = config.getLanguage();

    static {
        // Español
        textosES.put("menu.title", "===== MENÚ PRINCIPAL =====");
        textosES.put("menu.option1", "1. Ver configuración actual");
        textosES.put("menu.option2", "2. Cambiar configuración");
        textosES.put("menu.option3", "3. Ver pantalla de bienvenida");
        textosES.put("menu.option4", "4. Ejecutar simulador de conexiones");
        textosES.put("menu.option5", "5. Salir");
        textosES.put("menu.prompt", "Seleccione una opción:");
        textosES.put("exit", "👋 Saliendo del sistema...");
        textosES.put("invalid.option", "Opción inválida.");
        textosES.put("config.title", "--- CAMBIAR CONFIGURACIÓN ---");

        // Nuevas opciones de configuración
        textosES.put("change.currency", "Nueva moneda (ej: USD): ");
        textosES.put("change.language", "Nuevo idioma (ES/EN): ");
        textosES.put("change.timeFormat", "Formato de hora (24H/AM/PM): ");
        textosES.put("change.maxConnections", "Máx. conexiones: ");
        textosES.put("change.autoSaveInterval", "Intervalo (min): ");
        textosES.put("change.enableLogs", "Activar logs (true/false): ");
        textosES.put("change.theme", "Tema (light/dark): ");
        textosES.put("change.region", "Región (ej: LATAM): ");
        textosES.put("change.backupEnabled", "Activar respaldo (true/false): ");
        textosES.put("change.backupDirectory", "Ruta de respaldo: ");
        textosES.put("menu.option6", "6. Logs");
        textosES.put("menu.option7", "7. Tema");
        textosES.put("menu.option8", "8. Región");
        textosES.put("menu.option9", "9. Respaldos automáticos");
        textosES.put("menu.option10", "10. Ruta de respaldo");
        textosES.put("menu.option11", "11. Volver");

        // Inglés
        textosEN.put("menu.title", "===== MAIN MENU =====");
        textosEN.put("menu.option1", "1. View current configuration");
        textosEN.put("menu.option2", "2. Change configuration");
        textosEN.put("menu.option3", "3. Show welcome screen");
        textosEN.put("menu.option4", "4. Run connection simulator");
        textosEN.put("menu.option5", "5. Exit");
        textosEN.put("menu.prompt", "Choose an option:");
        textosEN.put("exit", "👋 Exiting system...");
        textosEN.put("invalid.option", "Invalid option.");
        textosEN.put("config.title", "--- CHANGE CONFIGURATION ---");

        // Nuevas opciones de configuración
        textosEN.put("change.currency", "New currency (e.g., USD): ");
        textosEN.put("change.language", "New language (ES/EN): ");
        textosEN.put("change.timeFormat", "Time format (24H/AM/PM): ");
        textosEN.put("change.maxConnections", "Max connections: ");
        textosEN.put("change.autoSaveInterval", "Interval (min): ");
        textosEN.put("change.enableLogs", "Enable logs (true/false): ");
        textosEN.put("change.theme", "Theme (light/dark): ");
        textosEN.put("change.region", "Region (e.g., LATAM): ");
        textosEN.put("change.backupEnabled", "Enable backup (true/false): ");
        textosEN.put("change.backupDirectory", "Backup directory: ");
        textosEN.put("menu.option6", "6. Logs");
        textosEN.put("menu.option7", "7. Theme");
        textosEN.put("menu.option8", "8. Region");
        textosEN.put("menu.option9", "9. Automatic backups");
        textosEN.put("menu.option10", "10. Backup directory");
        textosEN.put("menu.option11", "11. Back");
    }

    public static String get(String clave) {
        if ("EN".equalsIgnoreCase(idiomaActual)) {
            return textosEN.getOrDefault(clave, clave);
        } else {
            return textosES.getOrDefault(clave, clave);
        }
    }

    // Método para cambiar el idioma en tiempo real
    public static void setIdiomaActual(String nuevoIdioma) {
        idiomaActual = nuevoIdioma;
    }
}




