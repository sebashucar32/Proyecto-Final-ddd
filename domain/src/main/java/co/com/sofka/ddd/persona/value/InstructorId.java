package co.com.sofka.ddd.persona.value;

import co.com.sofka.domain.generic.Identity;

public class InstructorId extends Identity {
    private InstructorId(String value) {
        super(value);
    }

    public static InstructorId of(String value) {
        return new InstructorId(value);
    }
}
