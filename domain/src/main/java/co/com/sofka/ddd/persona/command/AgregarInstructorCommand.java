package co.com.sofka.ddd.persona.command;

import co.com.sofka.ddd.persona.InstructorFactory;
import co.com.sofka.ddd.persona.value.PersonaId;
import co.com.sofka.domain.generic.Command;

public class AgregarInstructorCommand extends Command {
    private final InstructorFactory instructorFactory;
    private final PersonaId personaId;

    public AgregarInstructorCommand(InstructorFactory instructorFactory, PersonaId personaId) {
        this.instructorFactory = instructorFactory;
        this.personaId = personaId;
    }

    public InstructorFactory getInstructorFactory() {
        return instructorFactory;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }
}
