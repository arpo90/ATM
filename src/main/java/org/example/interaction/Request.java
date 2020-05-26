package org.example.interaction;

import java.time.LocalDate;

public class Request {
    private String payload;

    public Request(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
