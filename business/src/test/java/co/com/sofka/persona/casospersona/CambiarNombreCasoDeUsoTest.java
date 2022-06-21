package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.persona.command.CambiarNombreCommand;
import co.com.sofka.ddd.persona.event.NombreCompletoCambiado;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CambiarNombreCasoDeUsoTest {
    @Test
    void cambiarNombrePersona() {
        NombreCompleto nombreCompleto = new NombreCompleto("Sebastian Huertas Cardona");
        NombreCompleto nombreCambiado = new NombreCompleto("Juan Sebastian Huertas Cardona");

        var command = new CambiarNombreCommand(nombreCompleto, nombreCambiado);
        var useCase = new CambiarNombreCasoDeUso();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreCompletoCambiado) events.get(0);
        Assertions.assertEquals("Juan Sebastian Huertas Cardona", event.getNombreCompleto().value());
    }
}
