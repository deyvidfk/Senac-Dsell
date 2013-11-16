package util;

public final class Chronometer {

    private static long startValue;
    private static long stopValue;
    private static long timeDiff;

    /**
     * Inicia a contagem temporal
     */
    public static void start() {
        // Obtém a hora atual em milissegundos.
        startValue = System.currentTimeMillis();
        stopValue = 0;
        timeDiff = 0;
    }

    /**
     * Calcula a diferença temporal
     */
    public static void stop() {
        stopValue = System.currentTimeMillis();
        timeDiff = stopValue - startValue;
    }

    /**
     * Retorna o diferença de tempo medida
     *
     * @return tempo em milisegundos
     */
    public static long elapsedTime() {
        return timeDiff;
    }
}
