package co.com.sofka.ddd.persona.event;

import co.com.sofka.ddd.persona.value.Correo;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreCompletoCambiado extends DomainEvent {
    private final NombreCompleto nombreCompleto;
    private final NombreCompleto nombreCambiado;

    public NombreCompletoCambiado(NombreCompleto nombreCompleto, NombreCompleto nombreCambiado) {
        super("persona.NombreCompletoCambiado");
        this.nombreCompleto = nombreCompleto;
        this.nombreCambiado = nombreCambiado;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public NombreCompleto getNombreCambiado() {
        return nombreCambiado;
    }
}
