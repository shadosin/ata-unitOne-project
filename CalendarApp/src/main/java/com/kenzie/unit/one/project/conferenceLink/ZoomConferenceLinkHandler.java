package com.kenzie.unit.one.project.conferenceLink;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ZoomConferenceLinkHandler implements ConferenceLinkHandler{

    @Override
    public void join(String meetingCode) {
        try {
            Desktop.getDesktop().browse(new URL("https://zoom.us/j/" + meetingCode).toURI());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalArgumentException("Could not join Zoom video conference");
        }
    }

}
