package app;

public class ConnectionSimulator {

    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public void iniciarSimulacion() {
        int maxConexiones = config.getMaxConnections();
        boolean logsActivados = config.isEnableLogs();
        String moneda = config.getDefaultCurrency();

        System.out.println("\n" + Idioma.get("connection.simulation.start"));
        int conexionesEstablecidas = 0;

        for (int i = 1; i <= maxConexiones; i++) {
            try {
                // Tiempo de conxion
                Thread.sleep(500); // medio segundo

                conexionesEstablecidas++;

                if (logsActivados) {
                    System.out.println(Idioma.get("connection.success") + i);
                }

            } catch (InterruptedException e) {
                if (logsActivados) {
                    System.out.println(Idioma.get("connection.error") + i + ": " + e.getMessage());
                }
            }
        }

        System.out.println(Idioma.get("simulation.end") + conexionesEstablecidas);
        System.out.println(Idioma.get("currency.default") + moneda);
    }
}

