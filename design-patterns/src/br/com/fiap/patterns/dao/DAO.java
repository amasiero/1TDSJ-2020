package br.com.fiap.patterns.dao;

import java.util.List;

public interface DAO<T> {
    List<T> findAll();
    T findById(long id);
    T save(T t);
    void update(T t);
    void delete(long id);
}
