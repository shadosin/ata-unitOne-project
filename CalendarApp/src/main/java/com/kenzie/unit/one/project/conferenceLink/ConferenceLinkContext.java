package com.kenzie.unit.one.project.conferenceLink;

public class ConferenceLinkContext {
    private ConferenceLinkHandler handler;

    public ConferenceLinkContext(String conferenceLinkType) {
        if (conferenceLinkType.equalsIgnoreCase("google")) {
            handler = new GoogleConferenceLinkHandler();
        } else if (conferenceLinkType.equalsIgnoreCase("zoom")) {
            handler = new ZoomConferenceLinkHandler();
        } else {
            throw new IllegalArgumentException("Invalid conference link type: " + conferenceLinkType);
        }
    }

    public void join(String meetingCode) {
        handler.join(meetingCode);
    }

}
