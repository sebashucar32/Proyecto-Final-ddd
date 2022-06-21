package co.com.sofka.tienda.casostienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.instalacion.command.AgregarMaquinaCommand;
import co.com.sofka.ddd.tienda.Tienda;
import co.com.sofka.ddd.tienda.command.AgregarProductoCommand;

public class AgregarProductoCasoDeUso extends UseCase<RequestCommand<AgregarProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProductoCommand> input) {
        var command = input.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value()));

        tienda.addProductos(command.getProductoFactory());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
