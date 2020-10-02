package br.com.fiap.patterns.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnection {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
