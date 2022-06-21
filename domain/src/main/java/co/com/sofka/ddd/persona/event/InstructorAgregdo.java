package co.com.sofka.ddd.persona.event;

import co.com.sofka.ddd.persona.value.EstudiosInstructor;
import co.com.sofka.ddd.persona.value.InstructorId;
import co.com.sofka.ddd.persona.value.RolInstructor;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorAgregdo extends DomainEvent {
    private final InstructorId instructorId;
    private final RolInstructor rolInstructor;
    private final EstudiosInstructor estudiosInstructor;

    public InstructorAgregdo(InstructorId instructorId, RolInstructor rolInstructor, EstudiosInstructor estudiosInstructor) {
        super("persona.InstructorAgregdo");
        this.instructorId = instructorId;
        this.rolInstructor = rolInstructor;
        this.estudiosInstructor = estudiosInstructor;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public RolInstructor getRolInstructor() {
        return rolInstructor;
    }

    public EstudiosInstructor getEstudiosInstructor() {
        return estudiosInstructor;
    }
}
