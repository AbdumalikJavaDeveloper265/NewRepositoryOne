package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name ;
    private final String surname;
    private final int age ;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("surname") String surname, @JsonProperty("age") int age) {
        this.id=id ;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
