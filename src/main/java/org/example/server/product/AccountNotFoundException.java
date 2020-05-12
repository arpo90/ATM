package org.example.server.product;

public class AccountNotFoundException extends Exception {
    private int code;
    private String desc;

    public AccountNotFoundException() {
        code = 0;
        desc = "";
    }

    public AccountNotFoundException(int code, String desc) {
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
