import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
    private static final String PROPERTIES_FILE = "properties";
    public static int START;
    public static int STOP;
    public static int INTERVAL;
    public static int INTERVAL_L;
    public static String FIREFOX;
    public static String LOGIN;
    public static String PASSWORD;

    public void config() {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
        } catch (IOException e) {
            System.err.println("Не найден файл " + PROPERTIES_FILE);
            e.printStackTrace();
        }
        START       = Integer.parseInt(properties.getProperty("START"));
        STOP        = Integer.parseInt(properties.getProperty("STOP"));
        LOGIN       = properties.getProperty("LOGIN");
        PASSWORD    = properties.getProperty("PASSWORD");
        INTERVAL    = Integer.parseInt (properties.getProperty("INTERVAL"));
        INTERVAL_L  = Integer.parseInt (properties.getProperty("INTERVAL_L"));
        FIREFOX     = properties.getProperty("FIREFOX");
    }
}
