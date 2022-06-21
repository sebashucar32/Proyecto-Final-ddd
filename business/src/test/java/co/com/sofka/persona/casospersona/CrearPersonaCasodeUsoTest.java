package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.persona.command.CrearPersonaCommand;
import co.com.sofka.ddd.persona.event.PersonaCreada;
import co.com.sofka.ddd.persona.value.Correo;
import co.com.sofka.ddd.persona.value.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrearPersonaCasodeUsoTest {
    @Test
    void crearPersona() {
        //arrange
        NombreCompleto nombreCompleto = new NombreCompleto("Sebastian Huertas Cardona");
        Correo correo = new Correo("sebastian.huertas@sofka.com.co");
        var command = new CrearPersonaCommand(nombreCompleto, correo);
        var useCase = new CrearPersonaCasoDeUso();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PersonaCreada) events.get(0);
        Assertions.assertEquals("Sebastian Huertas Cardona", event.getNombreCompleto().value());
        Assertions.assertEquals("sebastian.huertas@sofka.com.co", event.getCorreo().value());
    }
}
