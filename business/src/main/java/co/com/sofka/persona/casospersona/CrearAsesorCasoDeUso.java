package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.persona.Persona;
import co.com.sofka.ddd.persona.command.CrearAsesorCommand;

public class CrearAsesorCasoDeUso extends UseCase<RequestCommand<CrearAsesorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAsesorCommand> input) {
        var command = input.getCommand();
        var persona = Persona.from(command.getPersonaId(), repository().getEventsBy(command.getPersonaId().value()));

        persona.agregarAsesor(command.getAsesorFactory());
        emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));
    }
}
