package org.virosms.lectorversomicro.repository;

public enum LVDomain {
    SECURITY("security"),
    VALIDATION("validation"),
    ARCHICTECTURE("architecture"),
    COMPENSATION("compensation"),
    CONNECTION("connection");

    private final String value;

    private LVDomain(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
