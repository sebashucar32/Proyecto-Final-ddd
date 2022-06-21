package co.com.sofka.ddd.instalacion.value;

import co.com.sofka.domain.generic.ValueObject;

public class Sede implements ValueObject<String> {
    private final String value;

    public Sede(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
