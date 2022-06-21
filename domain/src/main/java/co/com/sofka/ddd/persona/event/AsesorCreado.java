package co.com.sofka.ddd.persona.event;

import co.com.sofka.ddd.persona.value.AsesorId;
import co.com.sofka.ddd.persona.value.EstudiosAsesor;
import co.com.sofka.ddd.persona.value.RolAsesor;
import co.com.sofka.domain.generic.DomainEvent;

public class AsesorCreado extends DomainEvent {
    private final AsesorId identity;
    private final RolAsesor rolAsesor;
    private final EstudiosAsesor estudiosAsesor;

    public AsesorCreado(AsesorId identity, RolAsesor rolAsesor, EstudiosAsesor estudiosAsesor) {
        super("persona.AsesorCreado");
        this.identity = identity;
        this.rolAsesor = rolAsesor;
        this.estudiosAsesor = estudiosAsesor;
    }

    public AsesorId getIdentity() {
        return identity;
    }

    public RolAsesor getRolAsesor() {
        return rolAsesor;
    }

    public EstudiosAsesor getEstudiosAsesor() {
        return estudiosAsesor;
    }
}
