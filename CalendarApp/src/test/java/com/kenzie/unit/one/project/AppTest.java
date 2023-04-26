package com.kenzie.unit.one.project;

import com.kenzie.unit.one.project.App;
import com.kenzie.unit.one.project.cmd.UserHandler;
import com.kenzie.unit.one.project.service.EventService;
import com.kenzie.unit.one.project.service.PersonService;
import com.kenzie.unit.one.project.service.VideoConferenceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppTest {

    /**
     * A test they could write to ensure that the PERSONS command returns a result
     */
    @Test
    void command_persons_exit_command() {
        // GIVEN - create app
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        VideoConferenceService videoConferenceService = mock(VideoConferenceService.class);
        UserHandler handler = mock(UserHandler.class);
        App app = new App(personService, eventService, videoConferenceService, handler);

        // WHEN - call command
        when(handler.getString(anyString())).thenReturn(App.QUERY_PERSONS_COMMAND, App.EXIT_COMMAND);
        boolean result = app.handleMenu();
        // THEN
        assertTrue(result, "Expect app to return true");
    }

    @Test
    void command_persons_add_result() {
        // GIVEN - create app
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        VideoConferenceService videoConferenceService = mock(VideoConferenceService.class);
        UserHandler handler = mock(UserHandler.class);
        App app = new App(personService, eventService, videoConferenceService, handler);

        // WHEN - call command
        String newPerson = "someone";
        when(handler.getString(anyString())).thenReturn(App.QUERY_PERSONS_COMMAND, App.CREATE_COMMAND, newPerson, App.EXIT_COMMAND);
        boolean result = app.handleMenu();
        // THEN
        assertTrue(result, "Expect app to return true");
    }


    @Test
    void command_quit_returns_no_result() {
        // GIVEN - create app
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        VideoConferenceService videoConferenceService = mock(VideoConferenceService.class);
        UserHandler handler = mock(UserHandler.class);

        App app = new App(personService, eventService, videoConferenceService, handler);

        // WHEN - call command
        when(handler.getString(anyString())).thenReturn(App.QUIT_COMMAND);
        boolean result = app.handleMenu();

        // THEN
        assertFalse(result, "Expect app to return false");
    }

    @Test
    void command_persons_add_person() {
        // GIVEN - create app
        PersonService personService = mock(PersonService.class);
        EventService eventService = mock(EventService.class);
        VideoConferenceService videoConferenceService = mock(VideoConferenceService.class);
        UserHandler handler = mock(UserHandler.class);

        App app = new App(personService, eventService, videoConferenceService, handler);

        // WHEN
        when(handler.getString(anyString())).thenReturn(App.QUERY_PERSONS_COMMAND, App.EXIT_COMMAND);
        //TODO: Change the value of the result variable to be set to the return value of handleMenu()
        //Hint: You may use the other provided test cases as a reference for how to do this
        boolean result = false;

        // THEN
        assertTrue(result, "Expect app to return true");
    }
}