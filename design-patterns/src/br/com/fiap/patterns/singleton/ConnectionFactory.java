package br.com.fiap.patterns.singleton;

import br.com.fiap.patterns.factory.Database;
import br.com.fiap.patterns.factory.MySQLConnection;
import br.com.fiap.patterns.factory.OracleConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        System.out.println("ConnectionFactory instanciada.");
    }

    public static synchronized ConnectionFactory getInstance() {
        if(instance == null) instance = new ConnectionFactory();
        return instance;
    }

    public Connection getConnection(Database database) throws IOException, SQLException, ClassNotFoundException {
        if(database == Database.ORACLE) return new OracleConnection().getConnection();
        if(database == Database.MYSQL) return  new MySQLConnection().getConnection();
        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
