package br.com.fiap.patterns.factory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

// Reflection
public class ConnectionReflectionFactory {

    public static Connection getConnection(Database database)
            throws IllegalAccessException,
            InstantiationException,
            ClassNotFoundException,
            SQLException,
            NoSuchMethodException,
            InvocationTargetException {
        // Defino a classe que quero utilizar
        Class<?> c = Class.forName("br.com.fiap.patterns.factory."
                + database.getValue() + "Connection");
        // Instância do objeto
        MyConnection conn = (MyConnection) c.getDeclaredConstructor().newInstance();
        // Retorno com o uso do método declarado no objeto
        return conn.getConnection();
    }
}
