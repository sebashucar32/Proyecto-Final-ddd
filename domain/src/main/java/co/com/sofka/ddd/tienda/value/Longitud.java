package co.com.sofka.ddd.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

public class Longitud implements ValueObject<String> {
    private final String value;

    public Longitud(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
