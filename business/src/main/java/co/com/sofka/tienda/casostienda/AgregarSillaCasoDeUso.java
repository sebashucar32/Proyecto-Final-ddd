package co.com.sofka.tienda.casostienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.instalacion.command.AgregarMaquinaCommand;
import co.com.sofka.ddd.tienda.Tienda;
import co.com.sofka.ddd.tienda.command.AgregarSillaCommand;

public class AgregarSillaCasoDeUso extends UseCase<RequestCommand<AgregarSillaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarSillaCommand> input) {
        var command = input.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value()));

        tienda.addSillas(command.getSillaFactory());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
