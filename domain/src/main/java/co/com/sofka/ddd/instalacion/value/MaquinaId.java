package co.com.sofka.ddd.instalacion.value;

import co.com.sofka.domain.generic.Identity;

public class MaquinaId extends Identity {
    private MaquinaId(String value) {
        super(value);
    }

    public MaquinaId() {}

    public static MaquinaId of(String value) {
        return new MaquinaId(value);
    }
}
