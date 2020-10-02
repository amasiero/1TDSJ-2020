package br.com.fiap.patterns.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements MyConnection {
    Properties props;

    public MySQLConnection() throws IOException {
        props = new Properties();
        props.load(new FileInputStream("application.properties"));
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                props.getProperty("mysql.url"),
                props.getProperty("mysql.user"),
                props.getProperty("mysql.password")
        );
    }
}
