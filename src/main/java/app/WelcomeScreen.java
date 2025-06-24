package app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WelcomeScreen {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void mostrar() {
        String lenguaje = config.getLanguage();
        String formatoHora = config.getTimeFormat();
        String tema = config.getTheme();

        // Determinar mensaje por idioma
        String mensajeBienvenida = Idioma.get("welcome.message");

        // Formatear hora
        String horaActual = obtenerHoraActual(formatoHora);

        // Estilo visual por tema
        String colorTexto, fondo;
        if ("light".equalsIgnoreCase(tema)) {
            colorTexto = "\u001B[30m"; // negro
            fondo = "\u001B[47m";      // fondo blanco
        } else {
            colorTexto = "\u001B[36m"; // cyan
            fondo = "\u001B[40m";      // fondo negro
        }
        String reset = "\u001B[0m";

        // Mostrar resultado
        System.out.println(fondo + colorTexto);
        System.out.println("====================================");
        System.out.println(mensajeBienvenida);
        System.out.println(Idioma.get("current.time") + horaActual);
        System.out.println(Idioma.get("current.theme") + tema);
        System.out.println(Idioma.get("current.language") + lenguaje);
        System.out.println(Idioma.get("current.timeFormat") + formatoHora);
        System.out.println("====================================" + reset);
    }

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


