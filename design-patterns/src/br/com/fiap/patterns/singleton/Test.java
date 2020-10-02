package br.com.fiap.patterns.singleton;

import br.com.fiap.patterns.factory.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        ObjetoSingleton obj1 = ObjetoSingleton.getInstance();
        ObjetoSingleton obj2 = ObjetoSingleton.getInstance();

        if(obj1 == obj2) {
            System.out.println("Os objetos são de origem da mesma instância.");
        }

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection(Database.ORACLE);
            if(conn != null) {
                System.out.println("Conexão realizada com sucesso");
                conn.close();
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
