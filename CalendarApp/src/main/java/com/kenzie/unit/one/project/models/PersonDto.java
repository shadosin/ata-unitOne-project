package com.kenzie.unit.one.project.models;

import java.io.Serializable;
import java.util.Objects;

public class PersonDto implements Serializable {
    private final String personId;
    private final String personName;

    public PersonDto(String personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(personId, personDto.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}
