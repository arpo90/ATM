package org.example;

public class Error {
    private int code;
    private String desc;

    public Error(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Error code=" + code + "; Message='" + desc;
    }
}
