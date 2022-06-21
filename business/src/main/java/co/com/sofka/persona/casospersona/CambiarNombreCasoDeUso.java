package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.persona.Persona;
import co.com.sofka.ddd.persona.command.CambiarNombreCommand;
import co.com.sofka.ddd.persona.value.PersonaId;

public class CambiarNombreCasoDeUso extends UseCase<RequestCommand<CambiarNombreCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombreCommand> input) {
        var command = input.getCommand();
        var persona = new Persona(new PersonaId(), command.getNombreCompleto(), command.getNombreCambiado());
        emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));
    }
}
