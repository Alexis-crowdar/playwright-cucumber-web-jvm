
package utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class PropertyManager {
    private static final ClassLoader loader;
    private static final String PROPERTY_FILE_NAME = "config.properties";
    private static final ThreadLocal<Properties> properties = new ThreadLocal<>();

    static {
        loader = PropertyManager.class.getClassLoader();
    }

    private PropertyManager() {
    }

    private static Properties getProperties() {
        if (properties.get() == null) {
            try {
                loadProperties();
            } catch (IOException var1) {
                throw new IllegalStateException(var1.getMessage());
            }
        }

        return properties.get();
    }

    public static String getProperty(String propertyKey) {
        return getProperties().getProperty(propertyKey);
    }

    private static void loadProperties() throws IOException {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        Properties clientProperties = new EncryptableProperties(encryptor);

        try (InputStream is = loader.getResourceAsStream(PROPERTY_FILE_NAME)) {
            clientProperties.load(is);

            properties.set(new EncryptableProperties(new StandardPBEStringEncryptor()));
            properties.get().putAll(clientProperties);
        } catch (IOException e) {
            throw new UnsupportedOperationException("Property file " + PROPERTY_FILE_NAME + " not found");
        }
    }
}