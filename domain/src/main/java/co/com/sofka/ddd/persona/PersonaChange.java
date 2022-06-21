package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.persona.event.AsesorCreado;
import co.com.sofka.ddd.persona.event.InstructorAgregdo;
import co.com.sofka.ddd.persona.event.NombreCompletoCambiado;
import co.com.sofka.ddd.persona.event.PersonaCreada;
import co.com.sofka.ddd.persona.value.AsesorId;
import co.com.sofka.ddd.persona.value.InstructorId;
import co.com.sofka.domain.generic.EventChange;

public class PersonaChange extends EventChange {
    public PersonaChange(Persona persona) {
        apply((PersonaCreada event) -> {
            persona.nombreCompleto = event.getNombreCompleto();
            persona.correo = event.getCorreo();
        });

        apply((NombreCompletoCambiado event) -> {
            persona.nombreCompleto = event.getNombreCompleto();
        });

        apply((AsesorCreado event) -> {
            Asesor asesor = new Asesor(AsesorId.of(""), event.getRolAsesor(), event.getEstudiosAsesor());
            persona.setAsesor(asesor);
        });

        apply((InstructorAgregdo event) -> {
            Instructor instructor = new Instructor(InstructorId.of(""), event.getRolInstructor(), event.getEstudiosInstructor());
            persona.setInstructor(instructor);
        });
    }
}
