package br.com.fiap.patterns.dao;

import br.com.fiap.patterns.model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQLPersonDAO implements DAO<Person> {

    private final Connection conn;

    public MySQLPersonDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Person> findAll() {
        try (conn) {
            List<Person> people = new ArrayList<>();
            String sql = "select * from tb_person";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Boolean active = rs.getBoolean("active");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();

                people.add(new Person(id, name, email, active, birthday));
            }

            return people;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Person findById(long id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        try (conn) {
            String sql = """
                      insert into tb_person(name, email, birthday, active)
                      values(?, ?, ?, ?)
                    """;
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, person.getName());
            pStmt.setString(2, person.getEmail());
            pStmt.setDate(3, Date.valueOf(person.getBirthday()));
            pStmt.setBoolean(4, person.getActive());
            pStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(long id) {

    }
}
