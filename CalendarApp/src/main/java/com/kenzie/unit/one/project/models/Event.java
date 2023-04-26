package com.kenzie.unit.one.project.models;

import java.time.Instant;
import java.util.Objects;

public class Event {

    private final String eventId;
    private final String eventTitle;
    private String videoConferenceProvider;
    private final Instant startTime;
    private final Instant endTime;

    public Event(String eventId,
                 String eventTitle,
                 Instant startTime,
                 Instant endTime,
                 String videoConferenceProvider) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.videoConferenceProvider = videoConferenceProvider;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public String getVideoConferenceProvider() {
        return videoConferenceProvider;
    }

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
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
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }


    public static class EventBuilder {

        private String eventId;
        private String eventTitle;
        private String videoConferenceProvider;
        private Instant startTime;
        private Instant endTime;

        public EventBuilder setEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public EventBuilder setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
            return this;
        }

        public EventBuilder setVideoConferenceProvider(String videoConferenceProvider) {
            this.videoConferenceProvider = videoConferenceProvider;
            return this;
        }

        public EventBuilder setStartTime(Instant startTime) {
            this.startTime = startTime;
            return this;
        }

        public EventBuilder setEndTime(Instant endTime) {
            this.endTime = endTime;
            return this;
        }

        public Event build() {
            return new Event(eventId, eventTitle, startTime, endTime, videoConferenceProvider);
        }
    }
}
