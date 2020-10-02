package br.com.fiap.patterns.dao;

import br.com.fiap.patterns.model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OraclePersonDAO implements DAO<Person> {
    private final Connection conn;

    public OraclePersonDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Person> findAll() {
        try (conn) {
            List<Person> people = new ArrayList<>();
            String sql = "select * from tb_person";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
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
            String sql = "select sq_person.nextval as id from dual";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Long id = null;
            if(rs.next()) id = rs.getLong("id");
            if(id != null) {
                person.setId(id);
                sql = """
                        insert into tb_person(id, name, email, birthday, active)
                        values(?, ?, ?, ?, ?)
                      """;
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setLong(1, id);
                pStmt.setString(2, person.getName());
                pStmt.setString(3, person.getEmail());
                pStmt.setDate(4, Date.valueOf(person.getBirthday()));
                pStmt.setBoolean(5, person.getActive());
                pStmt.execute();
            }

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
