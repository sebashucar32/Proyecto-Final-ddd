package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.value.EstudiosInstructor;
import co.com.sofka.ddd.persona.value.InstructorId;
import co.com.sofka.ddd.persona.value.RolInstructor;

import java.util.Objects;

public class InstructorFactory {
    private final Instructor instructor;
    private static InstructorFactory instance;

    private InstructorFactory() {
        this.instructor = new Instructor(InstructorId.of("spda32"), new RolInstructor("tfdgd"), new EstudiosInstructor("djfds"));
    }

    public static InstructorFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new InstructorFactory();
        }
        return instance;
    }

    public InstructorFactory agregarInstructor(InstructorId instructorId, RolInstructor rolInstructor, EstudiosInstructor estudiosInstructor) {
        instructor.setRolInstructor(rolInstructor);
        instructor.setEstudiosInstructor(estudiosInstructor);
        return this;
    }

    public Instructor instructor() {
        return instructor;
    }
}
