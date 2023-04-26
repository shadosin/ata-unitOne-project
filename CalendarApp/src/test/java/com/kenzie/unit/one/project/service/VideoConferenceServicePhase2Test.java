package com.kenzie.unit.one.project.service;

import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.MethodQuery;
import com.kenzie.unit.one.project.backend.Backend;
import com.kenzie.unit.one.project.models.Event;
import com.kenzie.unit.one.project.models.Person;
import com.kenzie.unit.one.project.models.VideoConferenceLink;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VideoConferenceServicePhase2Test {

    private static final String containingPackage = "com.kenzie.unit.one.project";

    @Test
    void join_conference_link_non_existing_event() {
        // GIVEN - create event service
        Backend backend = new Backend();
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> videoConferenceService.joinVideoConference(UUID.randomUUID().toString()), "Expected  to throw IllegalArgumentException");
    }

    @Test
    void join_conference_link_works() {
        Backend backend = new Backend();
        EventService eventService = new EventService(backend);
        PersonService personService = new PersonService(backend);
        VideoConferenceService videoConferenceService = new VideoConferenceService(backend);

        Person person = personService.getPersons().get(0);
        Event event = eventService.getMeetingEvents(person.getPersonId()).get(0);
        VideoConferenceLink conferenceLink = videoConferenceService.createEventConferenceLink(event.getEventId());

        // THEN
        assertDoesNotThrow(() -> videoConferenceService.joinVideoConference(conferenceLink.getEventId()),
                "Joining a valid conference should not throw an exception");
    }

    @Test
    void check_for_new_classes() {
        Class googleConferenceLinkHandlerClass = assertDoesNotThrow(()->ClassQuery
                        .inContainingPackage(containingPackage)
                        .withExactSimpleName("GoogleConferenceLinkHandler")
                        .findClassOrFail(),
                "GoogleConferenceLinkHandler class must exist");

        assertDoesNotThrow(()->
                        MethodQuery.inType(googleConferenceLinkHandlerClass)
                                .withExactName("join")
                                .withExactArgTypes(Arrays.asList(String.class))
                                .findMethodOrFail(),
                "GoogleConferenceLinkHandler must have a join method with a String parameter.");

        Class zoomConferenceLinkHandlerClass = assertDoesNotThrow(()->ClassQuery
                        .inContainingPackage(containingPackage)
                        .withExactSimpleName("ZoomConferenceLinkHandler")
                        .findClassOrFail(),
                "ZoomConferenceLinkHandler class must exist");

        assertDoesNotThrow(()->
                        MethodQuery.inType(zoomConferenceLinkHandlerClass)
                                .withExactName("join")
                                .withExactArgTypes(Arrays.asList(String.class))
                                .findMethodOrFail(),
                "ZoomConferenceLinkHandler must have a join method with a String parameter.");


        Class conferenceLinkContextClass = assertDoesNotThrow(()->ClassQuery
                        .inContainingPackage(containingPackage)
                        .withExactSimpleName("ConferenceLinkContext")
                        .findClassOrFail(),
                "ConferenceLinkContext class must exist");

        assertDoesNotThrow(()->
                        MethodQuery.inType(conferenceLinkContextClass)
                                .withExactName("join")
                                .withExactArgTypes(Arrays.asList(String.class))
                                .findMethodOrFail(),
                "ConferenceLinkContext must have a join method with a String parameter.");
    }
}
