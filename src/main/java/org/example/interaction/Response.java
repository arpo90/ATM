package org.example.interaction;

import org.example.server.product.Balance;

import java.util.Optional;

public class Response {
    private String payload;
    private int code;
    private String desc;


    public Response(String payload) {
        this.payload = payload;
        this.code = 0;
        this.desc = "Ok";
    }

    public Response(int code, String desc) {
        this.code = code;
        this.desc = desc;

        this.payload = "";
    }

    public String getPayload() {
        return payload;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
