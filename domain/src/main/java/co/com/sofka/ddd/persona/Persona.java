package co.com.sofka.ddd.persona;

import co.com.sofka.ddd.instalacion.value.InstalacionId;
import co.com.sofka.ddd.persona.event.AsesorCreado;
import co.com.sofka.ddd.persona.event.InstructorAgregdo;
import co.com.sofka.ddd.persona.event.NombreCompletoCambiado;
import co.com.sofka.ddd.persona.event.PersonaCreada;
import co.com.sofka.ddd.persona.value.Correo;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import co.com.sofka.ddd.persona.value.PersonaId;
import co.com.sofka.ddd.tienda.value.TiendaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Persona extends AggregateEvent<PersonaId> {
    protected Cliente cliente;
    protected Instructor instructor;
    protected Asesor asesor;
    protected NombreCompleto nombreCompleto;
    protected Correo correo;
    protected InstalacionId instalacionId;
    protected TiendaId tiendaId;

    public Persona(PersonaId personaId, NombreCompleto nombreCompleto, NombreCompleto nombreCambiado) {
        super(personaId);
        subscribe(new PersonaChange(this));
        appendChange(new NombreCompletoCambiado(nombreCompleto, nombreCambiado)).apply();
    }

    public Persona(PersonaId personaId, NombreCompleto nombreCompleto, Correo correo) {
        super(personaId);
        subscribe(new PersonaChange(this));
        appendChange(new PersonaCreada(nombreCompleto, correo)).apply();
    }

    private Persona(PersonaId personaId) {
        super(personaId);
        subscribe(new PersonaChange(this));
    }

    public static Persona from(PersonaId personaId, List<DomainEvent> eventsBy) {
        var persona = new Persona(personaId);
        eventsBy.forEach(persona::applyEvent);

        return persona;
    }

    public void agregarInstructor(InstructorFactory instructorFactory) {
        var instructor = instructorFactory.instructor();
        appendChange(new InstructorAgregdo(instructor.identity(), instructor.getRolInstructor(), instructor.getEstudiosInstructor()));
    }

    public void agregarAsesor(AsesorFactory asesorFactory) {
        var asesor = asesorFactory.asesor();
        appendChange(new AsesorCreado(asesor.identity(), asesor.getRolAsesor(), asesor.getEstudiosAsesor()));
    }

    public void iniciarTemperatura() {

    }

    public Cliente cliente() {
        return cliente;
    }

    public Instructor instructor() {
        return instructor;
    }

    public Asesor asesor() {
        return asesor;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public Correo correo() {
        return correo;
    }

    public InstalacionId instalacionId() {
        return instalacionId;
    }

    public TiendaId tiendaId() {
        return tiendaId;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
