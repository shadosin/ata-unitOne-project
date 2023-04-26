package com.kenzie.unit.one.project.service;

import com.kenzie.unit.one.project.backend.Backend;
import com.kenzie.unit.one.project.models.Event;
import com.kenzie.unit.one.project.models.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {


    @Test
    void return_events_for_person() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);

        // WHEN - call get meeting events
        Person person = personService.getPersons().get(0);
        List<Event> events = eventService.getMeetingEvents(person.getPersonId());

        // THEN
        assertTrue(events.size() > 0, "Expected events to be returned for person");
    }

    @Test
    void return_zero_events_for_person_that_does_not_exist() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);

        // WHEN - construct TimestampedData
        String person = "Someone";

        // THEN
        assertThrows(IllegalArgumentException.class, () -> eventService.getMeetingEvents(person), "Expected to throw IllegalArgumentException");
    }

    //TODO: Finish the implementation of this test case
    @Test
    void share_calendar_returns_distinct_list() {
        // GIVEN

        // WHEN

        // THEN
        
        // Replace this line when you make the test
        assertTrue(false);
    }
}