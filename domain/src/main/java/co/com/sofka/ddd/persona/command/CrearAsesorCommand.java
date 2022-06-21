package co.com.sofka.ddd.persona.command;

import co.com.sofka.ddd.persona.AsesorFactory;
import co.com.sofka.ddd.persona.value.PersonaId;
import co.com.sofka.domain.generic.Command;

public class CrearAsesorCommand extends Command {
    private final AsesorFactory asesorFactory;

    private final PersonaId personaId;

    public CrearAsesorCommand(AsesorFactory asesorFactory, PersonaId personaId) {
        this.asesorFactory = asesorFactory;
        this.personaId = personaId;
    }

    public AsesorFactory getAsesorFactory() {
        return asesorFactory;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }
}
