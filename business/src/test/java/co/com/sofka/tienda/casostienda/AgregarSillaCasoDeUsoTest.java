package co.com.sofka.tienda.casostienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.tienda.SillaFactory;
import co.com.sofka.ddd.tienda.command.AgregarSillaCommand;
import co.com.sofka.ddd.tienda.event.SillaCreada;
import co.com.sofka.ddd.tienda.event.TiendaCreada;
import co.com.sofka.ddd.tienda.value.*;
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
public class AgregarSillaCasoDeUsoTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarSillaCasoDeUso useCase;

    private List<DomainEvent> history() {
        Accesorios accesorios = new Accesorios();

        return List.of(
                new TiendaCreada(accesorios),
                new SillaCreada(SillaId.of("psfoe"),
                        new Peso("per"),
                        new Longitud("dpsfks"))
        );
    }

    @Test
    public void agregarSillaAlaTienda() {
        SillaFactory factory = SillaFactory.getInstance()
                .add(SillaId.of("pro"), new Peso("100kg"), new Longitud("100cm"))
                .add(SillaId.of("pro1"), new Peso("112kg"), new Longitud("110cm"))
                .add(SillaId.of("pro2"), new Peso("130kg"), new Longitud("120cm"));

        TiendaId tiendaId = new TiendaId();
        var command = new AgregarSillaCommand(factory, tiendaId);
        when(repository.getEventsBy(tiendaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Assertions.assertEquals(3, events.size());
    }
}
