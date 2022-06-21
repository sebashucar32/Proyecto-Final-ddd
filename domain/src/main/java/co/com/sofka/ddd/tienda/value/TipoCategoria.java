package co.com.sofka.ddd.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

public class TipoCategoria implements ValueObject<String> {
    private final String value;

    public TipoCategoria(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
