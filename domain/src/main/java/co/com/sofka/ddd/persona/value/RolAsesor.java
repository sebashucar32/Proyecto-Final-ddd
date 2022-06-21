package co.com.sofka.ddd.persona.value;

import co.com.sofka.domain.generic.ValueObject;

public class RolAsesor implements ValueObject<String> {
    private final String value;

    public RolAsesor(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
