package co.com.sofka.ddd.tienda.event;

import co.com.sofka.ddd.tienda.value.Accesorios;
import co.com.sofka.domain.generic.DomainEvent;

public class TiendaCreada extends DomainEvent {
    private final Accesorios accesorios;

    public TiendaCreada(Accesorios accesorios) {
        super("tienda.TiendaCreada");
        this.accesorios = accesorios;
    }

    public Accesorios getAccesorios() {
        return accesorios;
    }
}
