package br.com.fiap.patterns.dao;


import br.com.fiap.patterns.factory.ConnectionFactory;
import br.com.fiap.patterns.factory.Database;
import br.com.fiap.patterns.model.Entity;

import java.io.IOException;
import java.sql.SQLException;

public class DAOFactory {

    public static DAO<?> getDao(Entity entity, Database database) throws SQLException, IOException, ClassNotFoundException {
        if(entity == Entity.PERSON && database == Database.ORACLE) {
            return new OraclePersonDAO(ConnectionFactory.getConnection(database));
        }
        if(entity == Entity.PERSON && database == Database.MYSQL) {
            return new MySQLPersonDAO(ConnectionFactory.getConnection(database));
        }
        return null;
    }

}
