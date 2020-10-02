package br.com.fiap.patterns.factory;

public enum Database {
    ORACLE("Oracle"),
    MYSQL("MySQL");

    private final String value;

    Database(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
