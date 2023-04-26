package com.kenzie.unit.one.project.models;

import java.util.Objects;

public class VideoConferenceLink {

    private final String eventId;
    private final String conferenceLinkProvider;
    private final String meetingCode;

    public VideoConferenceLink(String eventId,
                               String meetingCode,
                               String conferenceLinkProvider) {
        this.eventId = eventId;
        this.meetingCode = meetingCode;
        this.conferenceLinkProvider = conferenceLinkProvider;
    }

    public String getEventId() {
        return eventId;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public String getConferenceLinkProvider() {
        return conferenceLinkProvider;
    }

    public static VideoConferenceBuilder builder() {
        return new VideoConferenceBuilder();
    }

    @Override
    public String toString() {
        return "VideoConferenceLink{" +
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
        VideoConferenceLink that = (VideoConferenceLink) o;
        return Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }

    public static class VideoConferenceBuilder {

        private String eventId;
        private String meetingCode;
        private String conferenceLinkProvider;

        public VideoConferenceBuilder setEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public VideoConferenceBuilder setMeetingCode(String meetingCode) {
            this.meetingCode = meetingCode;
            return this;
        }

        public VideoConferenceBuilder setConferenceLinkProvider(String conferenceLinkProvider) {
            this.conferenceLinkProvider = conferenceLinkProvider;
            return this;
        }

        public VideoConferenceLink build() {
            return new VideoConferenceLink(eventId, meetingCode, conferenceLinkProvider);
        }
    }
}
