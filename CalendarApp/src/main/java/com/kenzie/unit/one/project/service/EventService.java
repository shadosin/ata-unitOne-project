package com.kenzie.unit.one.project.service;

import com.kenzie.unit.one.project.backend.Backend;
import com.kenzie.unit.one.project.models.Event;
import com.kenzie.unit.one.project.models.EventDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class EventService {
    private final Backend backend;
    private final Map<String, List<Event>> cache = new HashMap<>();

    public EventService(Backend backend) {
        this.backend = backend;
    }

    public List<Event> getMeetingEvents(String personId) {
        if (cache.containsKey(personId)) {
            return cache.get(personId);
        }
        List<EventDto> response = backend.getAllPersonMeetingEvents(personId);
        if (response == null) {
            throw new IllegalArgumentException("No events for person found");
        }
        List<Event> events = processResponse(response);
        cache.put(personId, events);
        return events;
    }

    public List<Event> shareCalendarEvents(String ownerPersonId, String personId) {
        List<EventDto> response = backend.sharedCalendarEvents(ownerPersonId, personId);
        if (response == null) {
            throw new IllegalArgumentException(
                    format("Please check that person ids %s and %s are correct", ownerPersonId, personId));
        }
        List<Event> events = processResponse(response);
        var ownerPersonEvents = cache.get(ownerPersonId);
        cache.put(personId, ownerPersonEvents);
        return events;
    }

    private List<Event> processResponse(List<EventDto> response) {
        List<Event> events = new ArrayList<>();
        for (EventDto eventDto : response) {
            Event event = Event
                    .builder()
                    .setEventId(eventDto.getEventId())
                    .setEventTitle(eventDto.getEventTitle())
                    .setStartTime(eventDto.getStartTime())
                    .setEndTime(eventDto.getEndTime())
                    .setVideoConferenceProvider(eventDto.getVideoConferenceProvider())
                    .build();
            events.add(event);
        }
        return events;
    }
}
