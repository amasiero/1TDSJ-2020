package br.com.fiap.patterns.model.dto;

import br.com.fiap.patterns.model.Person;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Person p = new Person("Zé Delivery", "zedelivery@ze.com", true, LocalDate.of(1983, 10, 29));
        showPerson(new PersonDTO(p));
    }

    public static void showPerson(PersonDTO person) {
        System.out.println(person.getName());
        System.out.println(person.getEmail());
        System.out.println(person.getBirthday());
    }
}
