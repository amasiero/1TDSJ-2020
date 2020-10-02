package br.com.fiap.patterns.dao.interfaces;

import java.util.List;

public interface PersonDAO {
    List<String> findAll();
    String findById(long id);
    String save(String person);
    void update(String person);
    void delete(long id);
}
