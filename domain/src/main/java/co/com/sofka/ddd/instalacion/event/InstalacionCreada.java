package co.com.sofka.ddd.instalacion.event;

import co.com.sofka.ddd.instalacion.value.Sede;
import co.com.sofka.domain.generic.DomainEvent;

public class InstalacionCreada extends DomainEvent {
    private final Sede sede;

    public InstalacionCreada(Sede sede) {
        super("instalacion.InstalacionCreada");
        this.sede = sede;
    }

    public Sede getSede() {
        return sede;
    }
}
