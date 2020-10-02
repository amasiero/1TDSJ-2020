package br.com.fiap.patterns.dao.interfaces;

import java.util.List;

public class MySQLPersonDAO implements PersonDAO {
    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public String findById(long id) {
        return null;
    }

    @Override
    public String save(String person) {
        return null;
    }

    @Override
    public void update(String person) {

    }

    @Override
    public void delete(long id) {

    }
}
