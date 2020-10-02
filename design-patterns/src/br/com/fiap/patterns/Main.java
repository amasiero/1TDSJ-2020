package br.com.fiap.patterns;

import br.com.fiap.patterns.dao.DAO;
import br.com.fiap.patterns.dao.DAOFactory;
import br.com.fiap.patterns.dao.generics.PersonDAO;
import br.com.fiap.patterns.factory.ConnectionFactory;
import br.com.fiap.patterns.factory.Database;
import br.com.fiap.patterns.model.Entity;
import br.com.fiap.patterns.model.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try {
            DAO<Person> dao = (DAO<Person>) DAOFactory.getDao(Entity.PERSON, Database.MYSQL);
            if(dao != null) {
                dao.save(new Person("Zé Delivery", "zedelivery@ze.com", true, LocalDate.of(1983, 10, 29)));
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
