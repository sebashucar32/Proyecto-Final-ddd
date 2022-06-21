package co.com.sofka.ddd.instalacion.event;

import co.com.sofka.ddd.instalacion.value.Descripcion;
import co.com.sofka.ddd.instalacion.value.MaquinaId;
import co.com.sofka.ddd.instalacion.value.TipoMaquina;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class MaquinaAgregada extends DomainEvent {
    private final MaquinaId identity;
    private final TipoMaquina tipoMaquina;
    private final Descripcion descripcion;

    public MaquinaAgregada(MaquinaId identity, TipoMaquina tipoMaquina, Descripcion descripcion) {
        super("instalacion.MaquinaAgregada");
        this.identity = identity;
        this.tipoMaquina = tipoMaquina;
        this.descripcion = descripcion;
    }

    public MaquinaId getIdentity() {
        return identity;
    }

    public TipoMaquina getTipoMaquina() {
        return tipoMaquina;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
