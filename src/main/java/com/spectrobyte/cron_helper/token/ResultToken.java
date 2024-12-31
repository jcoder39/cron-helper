package com.spectrobyte.cron_helper.token;

public class ResultToken {
    public enum Type {NUMBER, STRING, CHARACTER, NONE}
    public Type type;
    public String value;

    public ResultToken() {
        type = Type.NONE;
        value = "";
    }

    public ResultToken(Type type, String value) {
        this.type = type;
        this.value = value;
    }
}
