package co.com.sofka.ddd.tienda.event;

import co.com.sofka.ddd.tienda.value.Longitud;
import co.com.sofka.ddd.tienda.value.Peso;
import co.com.sofka.ddd.tienda.value.SillaId;
import co.com.sofka.domain.generic.DomainEvent;

public class SillaCreada extends DomainEvent {
    private final SillaId identity;
    private final Peso peso;
    private final Longitud longitud;

    public SillaCreada(SillaId identity, Peso peso, Longitud longitud) {
        super("tienda.SillaCreada");
        this.identity = identity;
        this.peso = peso;
        this.longitud = longitud;
    }

    public SillaId getIdentity() {
        return identity;
    }

    public Peso getPeso() {
        return peso;
    }

    public Longitud getLongitud() {
        return longitud;
    }
}
