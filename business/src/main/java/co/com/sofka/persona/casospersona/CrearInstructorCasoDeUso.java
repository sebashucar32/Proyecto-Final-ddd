package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.persona.Persona;
import co.com.sofka.ddd.persona.command.AgregarInstructorCommand;

public class CrearInstructorCasoDeUso extends UseCase<RequestCommand<AgregarInstructorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInstructorCommand> input) {
        var command = input.getCommand();
        var persona = Persona.from(command.getPersonaId(), repository().getEventsBy(command.getPersonaId().value()));

        persona.agregarInstructor(command.getInstructorFactory());
        emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));
    }
}
