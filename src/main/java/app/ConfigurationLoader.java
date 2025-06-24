package app;

public class ConfigurationLoader {
    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void mostrarConfiguracion() {
        // Muestra la configuración actual con traducción dinámica
        System.out.println("\n" + Idioma.get("config.title"));
        System.out.println(Idioma.get("menu.option1") + ": " + config.getDefaultCurrency()); // Moneda
        System.out.println(Idioma.get("menu.option2") + ": " + config.getLanguage()); // Idioma
        System.out.println(Idioma.get("menu.option3") + ": " + config.getTimeFormat()); // Formato de hora
        System.out.println(Idioma.get("menu.option4") + ": " + config.getMaxConnections()); // Máx. conexiones
        System.out.println(Idioma.get("menu.option5") + ": " + config.getAutoSaveInterval()); // Intervalo auto guardado
        System.out.println(Idioma.get("menu.option6") + ": " + (config.isEnableLogs() ? "Sí" : "No")); // Logs
        System.out.println(Idioma.get("menu.option7") + ": " + config.getTheme()); // Tema
        System.out.println(Idioma.get("menu.option8") + ": " + config.getRegion()); // Región
        System.out.println(Idioma.get("menu.option9") + ": " + (config.isBackupEnabled() ? "Sí" : "No")); // Respaldos automáticos
        System.out.println(Idioma.get("menu.option10") + ": " + config.getBackupDirectory()); // Ruta de respaldo
        System.out.println("===========================");
    }
}
