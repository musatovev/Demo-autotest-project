package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class CustomProperties {
    private static final Properties properties = new Properties();

    static {
        InputStream is = CustomProperties.class.getClassLoader().getResourceAsStream("env.properties");

        if (Objects.isNull(is)) throw new RuntimeException(new FileNotFoundException());

        try {
            properties.load(is);
        } catch (IOException ex) {
            throw new RuntimeException("RuntimeException on load property-file", ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

