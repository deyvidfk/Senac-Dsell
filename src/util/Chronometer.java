package util;

import static java.lang.System.currentTimeMillis;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class Chronometer {

    private static long startValue;
    private static long stopValue;
    private static long timeDiff;

    /**
     * Inicia a contagem temporal
     */
    public static void start() {
        // Obtém a hora atual em milissegundos.
        startValue = currentTimeMillis();
        stopValue = 0;
        timeDiff = 0;
    }

    /**
     * Calcula a diferença temporal
     */
    public static void stop() {
        stopValue = currentTimeMillis();
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
    private static final Logger LOG = getLogger(Chronometer.class.getName());

    private Chronometer() {
    }

}
