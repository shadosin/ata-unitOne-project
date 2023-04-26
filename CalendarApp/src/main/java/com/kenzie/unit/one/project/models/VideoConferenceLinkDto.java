package com.kenzie.unit.one.project.models;

import java.io.Serializable;
import java.util.Objects;

public class VideoConferenceLinkDto implements Serializable {
    private final String eventId;
    private final String meetingCode;

    public VideoConferenceLinkDto(String eventId, String meetingCode) {
        this.eventId = eventId;
        this.meetingCode = meetingCode;
    }

    public String getEventId() {
        return eventId;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoConferenceLinkDto that = (VideoConferenceLinkDto) o;
        return Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
