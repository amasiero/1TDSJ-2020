package br.com.fiap.patterns.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection implements MyConnection {

    Properties props;

    public OracleConnection() throws IOException {
        this.props = new Properties();
        this.props.load(new FileInputStream("application.properties"));
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                props.getProperty("oracle.url"),
                props.getProperty("oracle.user"),
                props.getProperty("oracle.password")
        );
    }

}
