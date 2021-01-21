package com.example.demo.services;

import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public void addPerson(Person person) {
        personDAO.insertPerson(person);
    }
    public List<Person> getAllPeople() {
        return personDAO.selectAllPeople();
    }

    public Optional<Person> SelectPersonById(UUID id) {
        return personDAO.getPersonById(id);
    }

    public void deletePerson(UUID id) {
        personDAO.deletePersonById(id);
    }

    public void updatePerson(UUID id, Person person) {
        personDAO.updatePersonById(id, person);
    }
}