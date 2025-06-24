package app;

import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);
    private final WelcomeScreen welcomeScreen = new WelcomeScreen();
    private final ConnectionSimulator simulator = new ConnectionSimulator();
    private final ConfigCommandHandler configHandler = new ConfigCommandHandler();
    private final ConfigurationLoader configLoader = new ConfigurationLoader();

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(Idioma.get("menu.prompt"));

            switch (opcion) {
                case 1:
                    configLoader.mostrarConfiguracion();
                    break;
                case 2:
                    cambiarConfiguracion();
                    break;
                case 3:
                    welcomeScreen.mostrar();
                    break;
                case 4:
                    simulator.iniciarSimulacion();
                    break;
                case 5:
                    System.out.println(Idioma.get("exit"));
                    break;
                default:
                    System.out.println(Idioma.get("invalid.option"));
            }

        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("\n" + Idioma.get("menu.title"));
        System.out.println(Idioma.get("menu.option1"));
        System.out.println(Idioma.get("menu.option2"));
        System.out.println(Idioma.get("menu.option3"));
        System.out.println(Idioma.get("menu.option4"));
        System.out.println(Idioma.get("menu.option5"));
        System.out.println("===========================");
    }


    public void cambiarConfiguracion() {
        System.out.println("\n" + Idioma.get("config.title"));
        System.out.println("1. " + Idioma.get("menu.option1"));  // Moneda
        System.out.println("2. " + Idioma.get("menu.option2"));  // Idioma
        System.out.println("3. " + Idioma.get("menu.option3"));  // Formato de hora
        System.out.println("4. " + Idioma.get("menu.option4"));  // Máx. conexiones
        System.out.println("5. " + Idioma.get("menu.option5"));  // Intervalo de auto guardado
        System.out.println("6. " + Idioma.get("menu.option6"));  // Logs
        System.out.println("7. " + Idioma.get("menu.option7"));  // Tema
        System.out.println("8. " + Idioma.get("menu.option8"));  // Región
        System.out.println("9. " + Idioma.get("menu.option9"));  // Respaldos automáticos
        System.out.println("10. " + Idioma.get("menu.option10")); // Ruta de respaldo
        System.out.println("11. " + Idioma.get("menu.option11")); // Volver
        System.out.println("===========================");

        int opcion = leerEntero(Idioma.get("menu.prompt"));

        switch (opcion) {
            case 1:
                configHandler.cambiarMoneda(leerTexto(Idioma.get("change.currency"))); // "Nueva moneda (ej: USD): "
                break;
            case 2:
                configHandler.cambiarIdioma(leerTexto(Idioma.get("change.language"))); // "Nuevo idioma (ES/EN): "
                break;
            case 3:
                configHandler.cambiarFormatoHora(leerTexto(Idioma.get("change.timeFormat"))); // "Formato de hora (24H/AM/PM): "
                break;
            case 4:
                configHandler.cambiarMaxConexiones(leerEntero(Idioma.get("change.maxConnections"))); // "Máx. conexiones: "
                break;
            case 5:
                configHandler.cambiarIntervaloAutoGuardado(leerEntero(Idioma.get("change.autoSaveInterval"))); // "Intervalo (min): "
                break;
            case 6:
                configHandler.cambiarLogs(leerBooleano(Idioma.get("change.enableLogs"))); // "Activar logs (true/false): "
                break;
            case 7:
                configHandler.cambiarTema(leerTexto(Idioma.get("change.theme"))); // "Tema (light/dark): "
                break;
            case 8:
                configHandler.cambiarRegion(leerTexto(Idioma.get("change.region"))); // "Región (ej: LATAM): "
                break;
            case 9:
                configHandler.cambiarRespaldo(leerBooleano(Idioma.get("change.backupEnabled"))); // "Activar respaldo (true/false): "
                break;
            case 10:
                configHandler.cambiarRutaRespaldo(leerTexto(Idioma.get("change.backupDirectory"))); // "Ruta de respaldo: "
                break;
            case 11:
                return;
            default:
                System.out.println(Idioma.get("invalid.option")); // "❗ Opción inválida."
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean leerBooleano(String mensaje) {
        System.out.print(mensaje);
        return Boolean.parseBoolean(scanner.nextLine());
    }
}

