package com.kenzie.unit.one.project.conferenceLink;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GoogleConferenceLinkHandler implements ConferenceLinkHandler {


    public void join(String meetingCode) {
        try {
            Desktop.getDesktop().browse(new URL("https://meet.google.com/" + meetingCode).toURI());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException("Could not join Google video conference");
        }
    }
}



