package br.com.fiap.patterns.dao.generics;

import java.util.List;

public class NumberDAO implements DAO<Long> {
    @Override
    public List<Long> findAll() {
        return null;
    }

    @Override
    public Long findById(long id) {
        return null;
    }

    @Override
    public Long save(Long aLong) {
        return null;
    }

    @Override
    public void update(Long aLong) {

    }

    @Override
    public void delete(long id) {

    }
}
