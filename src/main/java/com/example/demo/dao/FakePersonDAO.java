package com.example.demo.dao;

import com.example.demo.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonDAO implements PersonDAO {
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getSurname(), person.getAge()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe =  getPersonById(id);
        if (personMaybe == null) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return getPersonById(id).map(p -> {
            int indexOffToDeletePerson = DB.indexOf(person);
            if (indexOffToDeletePerson >= 0) {
                DB.set(indexOffToDeletePerson, person);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
