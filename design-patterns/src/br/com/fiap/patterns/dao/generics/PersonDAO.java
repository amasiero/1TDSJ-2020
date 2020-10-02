package br.com.fiap.patterns.dao.generics;

import br.com.fiap.patterns.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person> {

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(long id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(long id) {

    }
}
