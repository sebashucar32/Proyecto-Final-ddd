package co.com.sofka.ddd.instalacion.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoMaquina implements ValueObject<String> {
    private final String value;

    public TipoMaquina(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
