package io.github.doquanghop.payspring.constant;

public enum Locale {
    VIETNAM("vn"),

    US("us");

    private final String code;

     Locale(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
