package co.com.sofka.ddd.tienda.value;

import co.com.sofka.ddd.persona.value.AsesorId;
import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {
    private ProductoId(String value) {
        super(value);
    }

    public static ProductoId of(String value) {
        return new ProductoId(value);
    }
}
