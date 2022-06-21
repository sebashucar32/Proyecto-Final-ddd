package co.com.sofka.ddd.tienda;

import co.com.sofka.ddd.tienda.value.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SillaFactory {
    private Set<Silla> sillas;
    private static SillaFactory instance;

    private SillaFactory() {
        sillas = new HashSet<>();
    }

    public static SillaFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new SillaFactory();
            return instance;
        }
        return instance;
    }

    public SillaFactory add(SillaId sillaId, Peso peso, Longitud longitud) {
        sillas.add(new Silla(sillaId, peso, longitud));
        return this;
    }

    public Set<Silla> sillas() {
        return sillas;
    }
}
