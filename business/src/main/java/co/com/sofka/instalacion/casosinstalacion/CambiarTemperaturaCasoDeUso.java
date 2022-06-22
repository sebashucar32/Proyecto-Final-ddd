package co.com.sofka.instalacion.casosinstalacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ddd.instalacion.Instalacion;
import co.com.sofka.ddd.instalacion.command.CambiarTemperaturaCommand;
import co.com.sofka.ddd.instalacion.value.InstalacionId;

public class CambiarTemperaturaCasoDeUso extends UseCase<RequestCommand<CambiarTemperaturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTemperaturaCommand> input) {
        var command = input.getCommand();
        var instalacion = new Instalacion(new InstalacionId(), command.getTemperatura(), command.getTemperaturaCambiada());
    }
}
