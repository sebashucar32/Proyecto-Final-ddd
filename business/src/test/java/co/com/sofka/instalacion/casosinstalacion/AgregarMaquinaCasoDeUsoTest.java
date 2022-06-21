package co.com.sofka.instalacion.casosinstalacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.ddd.instalacion.MaquinaFactory;
import co.com.sofka.ddd.instalacion.command.AgregarMaquinaCommand;
import co.com.sofka.ddd.instalacion.event.InstalacionCreada;
import co.com.sofka.ddd.instalacion.event.MaquinaAgregada;
import co.com.sofka.ddd.instalacion.value.*;
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
public class AgregarMaquinaCasoDeUsoTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarMaquinaCasoDeUso useCase;

    private List<DomainEvent> history() {
        Sede sede = new Sede("Dosquebradas");

        return List.of(
            new InstalacionCreada(sede),
            new MaquinaAgregada(MaquinaId.of("sfmej"),
                    new TipoMaquina("Hombro"),
                    new Descripcion("Mancuerna"))
            );
    }

    @Test
    public void agregarMaquinaAlaInstalacion() {
        MaquinaFactory factory = MaquinaFactory.getInstance()
                .add(MaquinaId.of("aaa"), new TipoMaquina("Pierna"), new Descripcion("Prensa: Especial para los cuadriceps"))
                .add(MaquinaId.of("bbb"), new TipoMaquina("Biceps"), new Descripcion("Predicador: Especial para tonificar biceps"))
                .add(MaquinaId.of("ccc"), new TipoMaquina("Pecho"), new Descripcion("banco Inclinado"));

        InstalacionId id = new InstalacionId();
        var command = new AgregarMaquinaCommand(factory, id);
        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Assertions.assertEquals(3, events.size());
    }
}
