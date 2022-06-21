package co.com.sofka.persona.casospersona;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.persona.AsesorFactory;
import co.com.sofka.ddd.persona.command.CrearAsesorCommand;
import co.com.sofka.ddd.persona.event.PersonaCreada;
import co.com.sofka.ddd.persona.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearAsesorCasoDeUsoTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CrearAsesorCasoDeUso useCase;

    private List<DomainEvent> history() {
        NombreCompleto nombreCompleto = new NombreCompleto("Sebastian huertas Cardona");
        Correo correo = new Correo("sebastian.huertas@sofka.com.co");
        return List.of(new PersonaCreada(nombreCompleto, correo));
    }

    @Test
    public void agregarAsesorAlaPersona() {
        // arrange
        PersonaId id = new PersonaId();
        AsesorFactory factory = AsesorFactory.getInstance().agregar(AsesorId.of(id.value()), new RolAsesor("Administrativo"), new EstudiosAsesor("Asesor Comercial"));
        var command = new CrearAsesorCommand(factory, id);
        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Assertions.assertEquals(1, events.size()); // debe haber un parametro
    }
}

