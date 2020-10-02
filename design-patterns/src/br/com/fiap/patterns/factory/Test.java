package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            Connection connOracle = ConnectionFactory.getConnection(Database.ORACLE);
            if(connOracle != null) {
                System.out.println("Conexão com o Oracle realizada com sucesso");
                connOracle.close();
            }

            Connection connMySql = ConnectionFactory.getConnection(Database.MYSQL);
            if(connMySql != null) {
                System.out.println("Conexão com o MySQL realizada com sucesso");
                connMySql.close();
            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = ConnectionReflectionFactory.getConnection(Database.ORACLE);
            if(conn != null) {
                System.out.println("Conexão utilizando Reflection realizada com sucesso");
                conn.close();
            }
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
