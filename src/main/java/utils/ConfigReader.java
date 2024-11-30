package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }
    

    public static String getProperty(String key) {
        // Check for system property first
        String systemValue = System.getProperty(key);
        if (systemValue != null) {
            //return systemValue;
        }
        // Fallback to the config.properties file
        return properties.getProperty(key);
    }
}