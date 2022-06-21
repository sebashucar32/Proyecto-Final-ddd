package co.com.sofka.ddd.persona.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstudiosAsesor implements ValueObject<String> {
    private final String value;

    public EstudiosAsesor(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
