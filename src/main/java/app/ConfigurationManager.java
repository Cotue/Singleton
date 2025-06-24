package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static final String CONFIG_PATH = "config.json";

    // Parámetros de configuración
    private String defaultCurrency;
    private String timeFormat;
    private int maxConnections;
    private String language;
    private int autoSaveInterval;
    private boolean enableLogs;
    private String theme;
    private String region;
    private boolean backupEnabled;
    private String backupDirectory;

    // Constructor privado
    private ConfigurationManager() {
        // Intentar cargar desde archivo, si falla usar valores por defecto
        if (!loadConfig()) {
            setDefaultValues();
            saveConfig();
        }
    }

    // Método Singleton
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    // Cargar configuración desde JSON
    private boolean loadConfig() {
        try (FileReader reader = new FileReader(CONFIG_PATH)) {
            Gson gson = new Gson();
            ConfigurationData data = gson.fromJson(reader, ConfigurationData.class);

            // Copiar los valores
            this.defaultCurrency = data.defaultCurrency;
            this.timeFormat = data.timeFormat;
            this.maxConnections = data.maxConnections;
            this.language = data.language;
            this.autoSaveInterval = data.autoSaveInterval;
            this.enableLogs = data.enableLogs;
            this.theme = data.theme;
            this.region = data.region;
            this.backupEnabled = data.backupEnabled;
            this.backupDirectory = data.backupDirectory;

            return true;
        } catch (IOException e) {
            System.out.println("No se pudo leer config.json. Usando valores por defecto.");
            return false;
        }
    }


    // Guardar configuración en JSON
    public void saveConfig() {
        try (FileWriter writer = new FileWriter(CONFIG_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar la configuración: " + e.getMessage());
        }
    }

    // Establecer valores por defecto
    private void setDefaultValues() {
        this.defaultCurrency = "USD";
        this.timeFormat = "24H";
        this.maxConnections = 5;
        this.language = "EN";
        this.autoSaveInterval = 10;
        this.enableLogs = true;
        this.theme = "dark";
        this.region = "LATAM";
        this.backupEnabled = true;
        this.backupDirectory = "./backups";
    }

    // Getters y setters
    public String getDefaultCurrency() { return defaultCurrency; }
    public void setDefaultCurrency(String defaultCurrency) { this.defaultCurrency = defaultCurrency; }

    public String getTimeFormat() { return timeFormat; }
    public void setTimeFormat(String timeFormat) { this.timeFormat = timeFormat; }

    public int getMaxConnections() { return maxConnections; }
    public void setMaxConnections(int maxConnections) { this.maxConnections = maxConnections; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getAutoSaveInterval() { return autoSaveInterval; }
    public void setAutoSaveInterval(int autoSaveInterval) { this.autoSaveInterval = autoSaveInterval; }

    public boolean isEnableLogs() { return enableLogs; }
    public void setEnableLogs(boolean enableLogs) { this.enableLogs = enableLogs; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public boolean isBackupEnabled() { return backupEnabled; }
    public void setBackupEnabled(boolean backupEnabled) { this.backupEnabled = backupEnabled; }

    public String getBackupDirectory() { return backupDirectory; }
    public void setBackupDirectory(String backupDirectory) { this.backupDirectory = backupDirectory; }
}
