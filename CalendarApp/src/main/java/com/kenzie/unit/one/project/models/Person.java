package com.kenzie.unit.one.project.models;

import java.util.Objects;

public class Person {

    private final String personId;
    private final String personName;


    public Person(String personId,
                  String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(personId, person.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }

    public static class PersonBuilder {

        private String personId;
        private String personName;

        public PersonBuilder setPersonId(String personId) {
            this.personId = personId;
            return this;
        }

        public PersonBuilder setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public Person build() {
            return new Person(personId, personName);
        }
    }
}
