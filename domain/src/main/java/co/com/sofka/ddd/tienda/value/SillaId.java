package co.com.sofka.ddd.tienda.value;

import co.com.sofka.domain.generic.Identity;

public class SillaId extends Identity {
    private SillaId(String value) {
        super(value);
    }

    public static SillaId of(String value) {
        return new SillaId(value);
    }
}
