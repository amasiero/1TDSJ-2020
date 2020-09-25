package br.com.fiap.pousada.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileHelper {

    public static Properties loadProperties() throws IOException {
        FileInputStream fis = new FileInputStream("application.properties");
        Properties props = new Properties();
        props.load(fis);
        fis.close();
        return props;
    }

}
