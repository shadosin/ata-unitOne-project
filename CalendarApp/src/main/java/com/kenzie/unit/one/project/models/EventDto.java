package com.kenzie.unit.one.project.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class EventDto implements Serializable {

    private final String eventId;
    private final String eventTitle;
    private String videoConferenceProvider;
    private final Instant startTime;
    private final Instant endTime;

    public EventDto(String eventId,
                    String eventTitle,
                    String videoConferenceProvider,
                    Instant startTime,
                    Instant endTime) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.videoConferenceProvider = videoConferenceProvider;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getVideoConferenceProvider() {
        return videoConferenceProvider;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventDto eventDto = (EventDto) o;
        return Objects.equals(eventId, eventDto.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
