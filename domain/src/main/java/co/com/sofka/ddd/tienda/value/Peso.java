package co.com.sofka.ddd.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

public class Peso implements ValueObject<String> {
    private final String value;

    public Peso(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
