package br.com.fiap.patterns.dao.generics;

import java.util.List;

// Generics ou Programação Genérica
public interface DAO<T> {
    List<T> findAll();
    T findById(long id);
    T save(T t);
    void update(T t);
    void delete(long id);
}
