package co.com.sofka.ddd.persona.event;

import co.com.sofka.ddd.persona.value.Correo;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonaCreada extends DomainEvent {
    private final NombreCompleto nombreCompleto;
    private final Correo correo;

    public PersonaCreada(NombreCompleto nombreCompleto, Correo correo) {
        super("persona.PersonaCreada");
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Correo getCorreo() {
        return correo;
    }
}
