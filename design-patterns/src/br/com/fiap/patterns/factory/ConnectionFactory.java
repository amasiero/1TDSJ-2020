package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// Factory -> Catalogo do GoF Patterns
public class ConnectionFactory {

    public static Connection getConnection(Database database) throws IOException, SQLException, ClassNotFoundException {
        if(database == Database.ORACLE) return new OracleConnection().getConnection();
        if(database == Database.MYSQL) return  new MySQLConnection().getConnection();
        return null;
    }
}
