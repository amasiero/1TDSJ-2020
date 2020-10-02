package br.com.fiap.patterns.dao.generics;

import br.com.fiap.patterns.model.Person;

public class Test {
    public static void main(String[] args) {
        DAO<Person> personDao = new PersonDAO(); // Declaração com tipo fixo
        DAO<?> dao = new PersonDAO(); /// Declaração Coringa
        dao = new NumberDAO();
    }
}
