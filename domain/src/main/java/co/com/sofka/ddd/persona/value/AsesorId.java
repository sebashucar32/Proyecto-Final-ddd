package co.com.sofka.ddd.persona.value;

import co.com.sofka.domain.generic.Identity;

public class AsesorId extends Identity {
    private AsesorId(String value) {
        super(value);
    }

    public static AsesorId of(String value) {
        return new AsesorId(value);
    }
}
