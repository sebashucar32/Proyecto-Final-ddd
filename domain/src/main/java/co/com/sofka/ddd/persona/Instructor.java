package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.value.EstudiosInstructor;
import co.com.sofka.ddd.persona.value.InstructorId;
import co.com.sofka.ddd.persona.value.RolInstructor;
import co.com.sofka.domain.generic.Entity;

public class Instructor extends Entity<InstructorId> {
    private RolInstructor rolInstructor;
    private EstudiosInstructor estudiosInstructor;

    public Instructor(InstructorId entityId, RolInstructor rolInstructor, EstudiosInstructor estudiosInstructor) {
        super(entityId);
        this.rolInstructor = rolInstructor;
        this.estudiosInstructor = estudiosInstructor;
    }

    public RolInstructor getRolInstructor() {
        return rolInstructor;
    }

    public EstudiosInstructor getEstudiosInstructor() {
        return estudiosInstructor;
    }

    public void setRolInstructor(RolInstructor rolInstructor) {
        this.rolInstructor = rolInstructor;
    }

    public void setEstudiosInstructor(EstudiosInstructor estudiosInstructor) {
        this.estudiosInstructor = estudiosInstructor;
    }
}
