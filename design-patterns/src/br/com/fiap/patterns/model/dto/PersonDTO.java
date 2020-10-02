package br.com.fiap.patterns.model.dto;

// DTO -> Data Transfer Object
// Core J2EE Pattern

import br.com.fiap.patterns.model.Person;

import java.time.LocalDate;

public class PersonDTO {
    private String name;
    private String email;
    private LocalDate birthday;

    public PersonDTO(Person person) {
        name = person.getName();
        email = person.getEmail();
        birthday = person.getBirthday();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
