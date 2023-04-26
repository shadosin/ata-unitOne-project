package com.kenzie.unit.one.project.service;

import com.kenzie.unit.one.project.backend.Backend;
import com.kenzie.unit.one.project.models.Event;
import com.kenzie.unit.one.project.models.Person;
import com.kenzie.unit.one.project.models.VideoConferenceLink;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VideoConferenceServiceTest {
    @Test
    void create_event_conference_link() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN - call get create event link
        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);

       
        //CNR: Fix - otherwise the test will always fail 
        VideoConferenceLink conferenceLink  = videoConferenceService.createEventConferenceLink(event.getEventId());

        if (videoConferenceService.getEventConferenceLink(event.getEventId()) == null) {
            conferenceLink = videoConferenceService.createEventConferenceLink(event.getEventId());
        } else {
            conferenceLink = videoConferenceService.getEventConferenceLink(event.getEventId());
        }

        // THEN
        assertNotNull(conferenceLink.getMeetingCode(), "Expected conference link to not be null");
    }

    @Test
    void create_event_conference_link_multiple_throws_illegal_argument_exception() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN - call get create event link
        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);
        VideoConferenceLink conferenceLink = videoConferenceService.createEventConferenceLink(event.getEventId());

        // THEN
        assertNotNull(conferenceLink.getMeetingCode(), "Expected conference link to not be null");
        assertThrows(IllegalArgumentException.class, () -> videoConferenceService.createEventConferenceLink(event.getEventId()), "Expected  to throw IllegalArgumentException");
    }

    //TODO: Finish the implementation of this test case
    @Test
    void get_conference_link_already_created() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN - call get create event link
        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);
        VideoConferenceLink conferenceLink = videoConferenceService.createEventConferenceLink(event.getEventId());

        // THEN
        // TODO: Complete the test stub
        assertEquals(conferenceLink.getMeetingCode(), "replace this with the correct meeting code!", "Expected conference link to be the same");
    }

    //TODO: Finish the implementation of this test case
    @Test
    void delete_conference_link_already_created() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN - call get create event link
        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);
        VideoConferenceLink conferenceLink = videoConferenceService.createEventConferenceLink(event.getEventId());

        // THEN
        assertNotNull(conferenceLink.getMeetingCode(), "Expected conference link to not be null");

        // TODO: Complete the test stub
        assertThrows(IllegalArgumentException.class, () -> videoConferenceService.getEventConferenceLink(event.getEventId()), "Expected to throw IllegalArgumentException");
    }

    @Test
    void create_conference_link_non_existing_event() {
        // GIVEN - create event service
        Backend backend = new Backend();
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> videoConferenceService.createEventConferenceLink(UUID.randomUUID().toString()), "Expected  to throw IllegalArgumentException");
    }

    //TODO: Finish the implementation of this test case
    @Test
    void get_conference_link_non_existing_event() {
        // GIVEN - create event service
        // TODO: Complete the test stub

        // THEN
        // TODO: Complete the test stub after removing the fail statement below.
        fail("Remove this line and implement the test case");
    }

    @Test
    void get_conference_link_non_existing_conference_link() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN
        Person person = personService.getPersons().get(0);


        // THEN
        assertThrows(IllegalArgumentException.class, () -> videoConferenceService.getEventConferenceLink(UUID.randomUUID().toString()), "Expected  to throw IllegalArgumentException");
    }

    //TODO: Finish the implementation of this test case
    @Test
    void join_conference_link_non_existing_conference_link() {
        // GIVEN - create event service
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // WHEN
        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);

        // THEN
        // TODO: Complete the test stub after removing the fail statement below.
        fail("Remove this line and implement the test case");
    }
}
