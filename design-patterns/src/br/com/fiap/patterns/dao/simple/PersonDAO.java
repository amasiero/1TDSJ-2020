package br.com.fiap.patterns.dao.simple;

import java.util.List;

// DAO -> Data Access Object -- Objeto de acesso ao banco dados
// Catalogo -> Core J2EE Pattern
public class PersonDAO {

    public List<String> findAll() {
        return null; // O código do select
    }

    public String findById(long id) {
        return null; // O código do select com where
    }

    public String save(String person) {
        return person; // O código do insert
    }

    public void update(String person) {
        // O código do update
    }

    public void delete(long id) {
        // O código do delete
    }
}
