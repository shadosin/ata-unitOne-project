package com.kenzie.unit.one.project.service;

import com.kenzie.unit.one.project.backend.Backend;
import com.kenzie.unit.one.project.models.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonServiceTest {
    @Test
    void return_persons() {
        // GIVEN - create person service
        Backend backend = new Backend();
        PersonService personService = new PersonService(backend);

        // WHEN -  call get persons
        List<Person> persons = personService.getPersons();

        // THEN
        assertTrue(persons.size() > 0, "Expected persons to be returned for person");
    }

    @Test
    void add_person() {
        // GIVEN - create person service
        Backend backend = new Backend();
        PersonService personService = new PersonService(backend);

        // WHEN -  call get persons
        String personName = "Someone";
        Person person = personService.addPerson(personName);
        List<Person> persons = personService.getPersons();

        // THEN
        assertTrue(persons.contains(person), "Expected persons to be created");
    }
}