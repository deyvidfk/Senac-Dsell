package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class Time {

    public static String getDate() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(hoje);
    }

    public static String getTime() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        return sdf.format(hoje);
    }
    private static final Logger LOG = getLogger(Time.class.getName());

    private Time() {
    }
}
