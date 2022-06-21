package co.com.sofka.instalacion.casosinstalacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.instalacion.Instalacion;
import co.com.sofka.ddd.instalacion.command.AgregarMaquinaCommand;

public class AgregarMaquinaCasoDeUso extends UseCase<RequestCommand<AgregarMaquinaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMaquinaCommand> input) {
        var command = input.getCommand();
        var instalacion = Instalacion.from(command.getInstalacionId(), repository().getEventsBy(command.getInstalacionId().value()));

        instalacion.addMaquinas(command.getMaquinaFactory());
        emit().onResponse(new ResponseEvents(instalacion.getUncommittedChanges()));
    }
}
