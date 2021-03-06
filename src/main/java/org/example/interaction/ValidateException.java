package org.example.interaction;

public class ValidateException extends Exception{
    private int code;
    private String desc;

    public ValidateException() {
        code = 0;
        desc = "";
    }

    public ValidateException(int code, String desc) {
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
