package org.example.interaction;

public class Error {
    private int code;
    private String desc;

    public Error() {
        code = 0;
        desc = "";
    }

    public Error(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
