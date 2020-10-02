package br.com.fiap.patterns.model;

import java.time.LocalDate;

public class Person {
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private LocalDate birthday;

    public Person(String name, String email, Boolean active, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.active = active;
        this.birthday = birthday;
    }

    public Person(Long id, String name, String email, Boolean active, LocalDate birthday) {
        this(name, email, active, birthday);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
