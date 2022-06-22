package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.ddd.persona.event.NombreCompletoCambiado;

import java.util.List;

public class NotificarCorreoCasoDeUso extends UseCase<TriggeredEvent<NombreCompletoCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<NombreCompletoCambiado> input) {
        var event = input.getDomainEvent();
        var service = getService(EnviarCorreoService.class);

        //service.enviarCorreo(event.getCorreo(), "Se cambio su nombre en la app bodyech");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
