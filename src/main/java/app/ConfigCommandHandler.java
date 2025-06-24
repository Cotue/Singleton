package app;

public class ConfigCommandHandler {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void cambiarMoneda(String nuevaMoneda) {
        config.setDefaultCurrency(nuevaMoneda);
        config.saveConfig();
    }

    public void cambiarIdioma(String nuevoIdioma) {
        config.setLanguage(nuevoIdioma); // Cambia el idioma en la configuración
        config.saveConfig(); // Guarda el cambio en el archivo
        // Recargar los textos del sistema inmediatamente
        Idioma.setIdiomaActual(nuevoIdioma);
    }

    public void cambiarFormatoHora(String nuevoFormato) {
        config.setTimeFormat(nuevoFormato);
        config.saveConfig();
    }

    public void cambiarMaxConexiones(int maxConexiones) {
        config.setMaxConnections(maxConexiones);
        config.saveConfig();
    }

    public void cambiarIntervaloAutoGuardado(int minutos) {
        config.setAutoSaveInterval(minutos);
        config.saveConfig();
    }

    public void cambiarLogs(boolean habilitar) {
        config.setEnableLogs(habilitar);
        config.saveConfig();
    }

    public void cambiarTema(String nuevoTema) {
        config.setTheme(nuevoTema);
        config.saveConfig();
    }

    public void cambiarRegion(String nuevaRegion) {
        config.setRegion(nuevaRegion);
        config.saveConfig();
    }

    public void cambiarRespaldo(boolean habilitar) {
        config.setBackupEnabled(habilitar);
        config.saveConfig();
    }

    public void cambiarRutaRespaldo(String nuevaRuta) {
        config.setBackupDirectory(nuevaRuta);
        config.saveConfig();
    }
}


